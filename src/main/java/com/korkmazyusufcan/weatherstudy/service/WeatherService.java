package com.korkmazyusufcan.weatherstudy.service;

import com.korkmazyusufcan.weatherstudy.constants.Constants;
import com.korkmazyusufcan.weatherstudy.dto.WeatherDto;
import com.korkmazyusufcan.weatherstudy.dto.weatherstack.WeatherResponse;
import com.korkmazyusufcan.weatherstudy.model.Weather;
import com.korkmazyusufcan.weatherstudy.repository.WeatherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    public WeatherService(WeatherRepository weatherRepository,
                          RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherDto getWeatherByCityName(String cityName) {
        Optional<Weather> optionalWeather = weatherRepository.findFirstByRequestedCityNameOrderByObservationTimeDesc(cityName);

        return optionalWeather.map(weather -> {
            if(weather.getResponseLocalTime().isBefore(LocalDateTime.now().minusMinutes(30L))){
                log.info("Past More Than 30 Minutes From Last Weather Request");
                return createWeather(cityName);
            }
            log.info("Requested Data Already Exist ");
            return WeatherDto.convertDto(weather);
        }).orElseGet(()->createWeather(cityName));
    }

    private WeatherDto createWeather(String cityName) {
        try {
            WeatherResponse weatherResponse = restTemplate.getForObject(generateApiUrl(cityName), WeatherResponse.class);
            log.info("Weather Response Come From WeatherStackAPI");
            log.info(generateApiUrl(cityName));
            return WeatherDto.convertDto(saveWeather(weatherResponse,cityName));
        } catch (Exception exception){
            //TODO
            // Throw exception
            log.info(exception.getMessage());
            throw exception;
        }
    }

    private Weather saveWeather(WeatherResponse weatherResponse,String cityName) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Weather newWeather = new Weather(
                weatherResponse.getCurrent().getTemperature(),
                weatherResponse.getLocation().getCountry(),
                weatherResponse.getLocation().getName(),
                cityName,
                LocalDateTime.parse(weatherResponse.getLocation().getLocaltime(),dateTimeFormatter),
                //TODO
                // Calculate wanted time format "yyyy-MM-dd HH:mm:ss"
                LocalDateTime.now()
        );
        return weatherRepository.save(newWeather);
    }

    private String generateApiUrl(String cityName){
        return Constants.WEATHER_STACK_API_BASE_URL + Constants.WEATHER_STACK_API_KEY_PARAM + Constants.API_KEY + Constants.WEATHER_STACK_API_QUERY_PARAM + cityName;
    }
}

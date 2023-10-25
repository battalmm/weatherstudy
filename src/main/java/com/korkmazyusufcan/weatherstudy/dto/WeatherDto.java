package com.korkmazyusufcan.weatherstudy.dto;

import com.korkmazyusufcan.weatherstudy.model.Weather;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {
    private String cityName;
    private String country;
    private LocalDateTime observationTime;
    private Integer temperature;

    public static WeatherDto convertDto(Weather weather) {
        return new WeatherDto(
                weather.getCityName(),
                weather.getCountry(),
                weather.getObservationTime(),
                weather.getTemperature());
    }
}

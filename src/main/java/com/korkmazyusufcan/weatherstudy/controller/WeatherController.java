package com.korkmazyusufcan.weatherstudy.controller;

import com.korkmazyusufcan.weatherstudy.controller.validation.CityNameConstraint;
import com.korkmazyusufcan.weatherstudy.dto.WeatherDto;
import com.korkmazyusufcan.weatherstudy.service.WeatherService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/v1/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<WeatherDto> getWeatherByCityName(@PathVariable @CityNameConstraint String cityName){
        return ResponseEntity.ok(weatherService.getWeatherByCityName(cityName));
    }
}

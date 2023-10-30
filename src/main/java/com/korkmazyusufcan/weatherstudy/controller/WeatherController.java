package com.korkmazyusufcan.weatherstudy.controller;

import com.korkmazyusufcan.weatherstudy.controller.validation.CityNameConstraint;
import com.korkmazyusufcan.weatherstudy.dto.WeatherDto;
import com.korkmazyusufcan.weatherstudy.service.WeatherService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Weather-study Service API v1", description = "Search current weathers of given cities")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    @RateLimiter(name = "limit")
    @Operation(
            method = "GET",
            summary = "Search current weather for given city name",
            description = "API has a rate limit. It is 10 request in per minute. City name should be valid")
    public ResponseEntity<WeatherDto> getWeatherByCityName(@PathVariable @CityNameConstraint String cityName){
        return ResponseEntity.ok(weatherService.getWeatherByCityName(cityName));
    }
}

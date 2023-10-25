package com.korkmazyusufcan.weatherstudy.dto.weatherstack;

import lombok.Data;

@Data
public class WeatherResponse {
    private Current current;
    private Location location;
    private Request request;
}

package com.korkmazyusufcan.weatherstudy.dto.weatherstack;

import lombok.Data;

@Data
public class Request {
    private String type;
    private String query;
    private String language;
    private String unit;
}

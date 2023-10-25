package com.korkmazyusufcan.weatherstudy.dto.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Current {
    @JsonProperty("observation_time")
    private String observationTime;
    private Integer temperature;
    @JsonProperty("weather_code")
    private Integer weatherCode;
    @JsonProperty("weather_icons")
    private List<String> weatherIcons;
    @JsonProperty("weather_descriptions")
    private List<String> weatherDescriptions;
    @JsonProperty("wind_speed")
    private Integer windSpeed;
    @JsonProperty("wind_degree")
    private Integer windDegree;
    @JsonProperty("wind_dir")
    private String windDirection;
    private Integer pressure;
    private Integer precip;
    private Integer humidity;
    private Integer cloudcover;
    private Integer feelslike;
    @JsonProperty("uv_index")
    private Integer uvIndex;
    private Integer visibility;
    @JsonProperty("is_day")
    private String isDay;
}

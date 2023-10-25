package com.korkmazyusufcan.weatherstudy.dto.weatherstack;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {
    private String name;
    private String country;
    private String region;
    private Double lat;
    private Double lon;
    @JsonProperty("timezone_id")
    private String timezoneId;
    private String localtime;
    @JsonProperty("localtime_epoch")
    private String localtimeEpoch;
    @JsonProperty("utc_offset")
    private String utcOffset;
}

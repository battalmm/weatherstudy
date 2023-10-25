package com.korkmazyusufcan.weatherstudy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer temperature;
    private String country;
    private String cityName;
    private String requestedCityName;
    private LocalDateTime observationTime;
    private LocalDateTime responseLocalTime;

    public Weather(Integer temperature,
                   String country,
                   String cityName,
                   String requestedCityName,
                   LocalDateTime observationTime,
                   LocalDateTime responseLocalTime) {
        this.temperature = temperature;
        this.country = country;
        this.cityName = cityName;
        this.requestedCityName = requestedCityName;
        this.observationTime = observationTime;
        this.responseLocalTime = responseLocalTime;
    }
}

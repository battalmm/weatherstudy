package com.korkmazyusufcan.weatherstudy.repository;

import com.korkmazyusufcan.weatherstudy.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather,Long> {

    Optional<Weather> findFirstByRequestedCityNameOrderByObservationTimeDesc(String cityName);
}

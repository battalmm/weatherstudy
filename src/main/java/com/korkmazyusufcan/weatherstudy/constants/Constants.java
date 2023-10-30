package com.korkmazyusufcan.weatherstudy.constants;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Constants {

    public static String WEATHER_STACK_API_BASE_URL;
    public static String API_KEY;
    public static String CACHE_NAME_WEATHER;
    public static final String WEATHER_STACK_API_KEY_PARAM = "?access_key=";
    public static final String WEATHER_STACK_API_QUERY_PARAM = "&query=";

    @Value("${weather_stack.api.url}")
    public void setWeatherStackApiBaseUrl(String url){
        WEATHER_STACK_API_BASE_URL = url;
    }

    @Value("${weather_stack.api.key}")
    public void setApiKey(String key){
        API_KEY = key;
    }

    @Value("${weather_stack.cache.weather.name}")
    public void setCacheNameWeather(String key){
        CACHE_NAME_WEATHER = key;
    }
}

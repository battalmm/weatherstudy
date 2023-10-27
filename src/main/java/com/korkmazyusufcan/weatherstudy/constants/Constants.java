package com.korkmazyusufcan.weatherstudy.constants;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Constants {
    // public static API_URL =
    //"http://api.weatherstack.com/current?access_key=42e877a6a9a2f9889f5c26160badb00a&query=";

    public static String WEATHER_STACK_API_BASE_URL;
    public static String API_KEY;
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
}

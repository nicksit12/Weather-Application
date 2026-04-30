package com.example.weather_app.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenMeteoClient {

    private final RestTemplate restTemplate;

    public OpenMeteoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getForecastJson(double latitude, double longitude) {
        String url = "https://api.open-meteo.com/v1/forecast"
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&hourly=temperature_2m,wind_speed_10m,precipitation_probability"
                + "&forecast_days=1";

        return restTemplate.getForObject(url, String.class);
    }
}
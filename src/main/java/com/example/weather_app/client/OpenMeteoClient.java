package com.example.weather_app.client;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.weather_app.model.WeatherData;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;


@Component
public class OpenMeteoClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public OpenMeteoClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper; 

    }

    public WeatherData getWeatherData(double latitude, double longitude) {
        String url = "https://api.open-meteo.com/v1/forecast"
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&hourly=temperature_2m,wind_speed_10m,precipitation_probability"
                + "&forecast_days=1";
        
        try {
            String json = restTemplate.getForObject(url, String.class);

            JsonNode root = objectMapper.readTree(json);
            JsonNode hourly = root.get("hourly");

            double temperature = hourly.get("temperature_2m").get(0).asDouble();
            double windSpeed = hourly.get("wind_speed_10m").get(0).asDouble(); 
            double precipitationProbability = hourly.get("precipitation_probability").get(0).asDouble(); 

            return new WeatherData(temperature, windSpeed, precipitationProbability);



        }catch (Exception e) {
            throw new RuntimeException("Failed to fetch or parse weather data", e);

        }


    }
}
package com.example.weather_app.controller; 

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather_app.client.OpenMeteoClient;



@RestController 
public class WeatherController {

    private final OpenMeteoClient openMeteoClient;

    public WeatherController(OpenMeteoClient openMeteoClient){
        this.openMeteoClient = openMeteoClient; 
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Weather app is running");
    }

    @GetMapping("/health")
    public Map<String, String> health(){ 
        return Map.of("status", "ok"); 
    }

    @GetMapping("/forecast/raw")
    public String getRawForecast( @RequestParam double longitude, @RequestParam double latitude) 
    {
        return openMeteoClient.getForecastJson(latitude, longitude);
    } 
    
}

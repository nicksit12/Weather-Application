package com.example.weather_app.controller; 

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather_app.model.WeatherResponse;
import com.example.weather_app.service.WeatherService;




@RestController 
public class WeatherController {
    private final WeatherService weatherService; 


    public WeatherController(WeatherService weatherService){
        this.weatherService = weatherService; 
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Weather app is running");
    }

    @GetMapping("/health")
    public Map<String, String> health(){ 
        return Map.of("status", "ok"); 
    }


    @GetMapping("/weather")
        public WeatherResponse getWeather(@RequestParam double latitude, @RequestParam double longitude)
    {
        return weatherService.getWeatherRecommendation(latitude, longitude);
    }
    
}

package com.example.weather_app.controller; 

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RestController; 

@RestController 
public class WeatherController {
    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Weather app is running");
    }

    @GetMapping("/health")
    public Map<String, String> health(){ 
        return Map.of("status", "ok"); 
    }
}

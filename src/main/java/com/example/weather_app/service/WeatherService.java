package com.example.weather_app.service;

import org.springframework.stereotype.Service;

import com.example.weather_app.client.OpenMeteoClient;
import com.example.weather_app.model.WeatherData;
import com.example.weather_app.model.WeatherResponse;

@Service
public class WeatherService {
    
    private final OpenMeteoClient openMeteoClient;

    public WeatherService(OpenMeteoClient openMeteoClient){
        this.openMeteoClient = openMeteoClient;

    }


    public WeatherResponse getWeatherRecommendation(double latitude, double longitude){

        WeatherData data = openMeteoClient.getWeatherData(latitude, longitude);
        String recommendation = getRecommendation(data);
        return new WeatherResponse(data.getPrecipitationProbability(), data.getTemperature(), data.getWindSpeed(), recommendation);

    }

    public String getRecommendation(WeatherData data){

        if (data.getPrecipitationProbability() > 60){
            return "It will be raining make sure to drive safely";
        }
        if (data.getTemperature() > 50 ){
            return "It is going to be hot, do not wear layers";
        }
        if (data.getWindSpeed() > 20){
            return "it is windy it would be best to walk with caution";
        }
        else{
            return "weather is good";
        }
    }





}


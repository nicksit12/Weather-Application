package com.example.weather_app.model;

public class WeatherResponse {

    private double temperature;
    private double windSpeed;
    private double precipitationProbability;
    private String recommendation;

    public WeatherResponse() {
    }

    public WeatherResponse(double temperature, double windSpeed, double precipitationProbability, String recommendation) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.precipitationProbability = precipitationProbability;
        this.recommendation = recommendation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(double precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}
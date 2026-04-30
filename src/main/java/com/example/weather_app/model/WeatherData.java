package com.example.weather_app.model;

public class WeatherData {

    private double temperature;
    private double windSpeed;
    private double precipitationProbability;

    public WeatherData() {
    }

    public WeatherData(double temperature, double windSpeed, double precipitationProbability) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.precipitationProbability = precipitationProbability;
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
}
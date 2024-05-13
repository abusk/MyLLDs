package org.myllds.wether.client;

import org.myllds.wether.model.WeatherData;
import org.myllds.wether.subject.Observer;

public class ForecastDisplay implements Observer, DisplayElement{
    private WeatherData weatherData;
    private WeatherData previousData;

    public ForecastDisplay() {
        this.previousData = new WeatherData(0, 0, 0);
        this.weatherData = new WeatherData(0, 0, 0);
    }
    @Override
    public void display() {
        System.out.println("Current Weather Data:");
        String tmpT = weatherData.getTemp() > previousData.getTemp() ? "Increased" : "Decreased";
        System.out.println("Temperature:" + tmpT);
        String tmpH = weatherData.getHumidity() > previousData.getHumidity() ? "Increased" : "Decreased";
        System.out.println("Humidity: " + tmpH);
        String tmpP = weatherData.getPressure() > previousData.getPressure() ? "Increased" : "Decreased";
        System.out.println("Pressure : " + tmpP);
    }

    @Override
    public void update(WeatherData weatherData) {
        previousData.setTemp(this.weatherData.getTemp());
        previousData.setHumidity(this.weatherData.getHumidity());
        previousData.setPressure(this.weatherData.getPressure());
        this.weatherData.setTemp(weatherData.getTemp());
        this.weatherData.setHumidity(weatherData.getHumidity());
        this.weatherData.setPressure(weatherData.getPressure());
        display();
    }
}

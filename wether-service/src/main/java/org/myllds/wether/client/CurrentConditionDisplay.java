package org.myllds.wether.client;

import org.myllds.wether.model.WeatherData;
import org.myllds.wether.subject.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;

    public CurrentConditionDisplay() {
        this.weatherData = new WeatherData(0, 0, 0);
    }
    @Override
    public void display() {
        System.out.println("Current Weather Data:");
        System.out.println("Temperature:" + weatherData.getTemp());
        System.out.println("Humidity: " + weatherData.getHumidity());
        System.out.println("Pressure : " + weatherData.getPressure());
    }

    @Override
    public void update(WeatherData weatherData) {
        this.weatherData.setTemp(weatherData.getTemp());
        this.weatherData.setHumidity(weatherData.getHumidity());
        this.weatherData.setPressure(weatherData.getPressure());
        display();
    }
}

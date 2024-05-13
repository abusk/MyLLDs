package org.myllds.wether.service;

import org.myllds.wether.model.WeatherData;
import org.myllds.wether.subject.Observer;
import org.myllds.wether.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherService implements Subject {

    private final WeatherData weatherData;
    private final List<Observer> observerList;

    public WeatherService() {
        this.weatherData = new WeatherData(0, 0, 0);
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observerList.indexOf(observer);
        if (i >= 0) {
            observerList.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(weatherData);
        }
    }

    public void updateMeasurement(WeatherData weatherData) {
        this.weatherData.setTemp(weatherData.getTemp());
        this.weatherData.setHumidity(weatherData.getHumidity());
        this.weatherData.setPressure(weatherData.getPressure());
        notifyObservers();
    }
}

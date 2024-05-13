package org.myllds.wether;

import org.myllds.wether.client.CurrentConditionDisplay;
import org.myllds.wether.client.ForecastDisplay;
import org.myllds.wether.collector.WeatherDataCollector;
import org.myllds.wether.model.WeatherData;
import org.myllds.wether.service.WeatherService;

public class WeatherStation {
    public static void main(String[] args) {

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        WeatherService weatherService = new WeatherService();
        weatherService.registerObserver(currentConditionDisplay);
        weatherService.registerObserver(forecastDisplay);

        WeatherDataCollector weatherDataCollector = new WeatherDataCollector();
        weatherService.updateMeasurement(weatherDataCollector.collect("BNG"));
        weatherService.updateMeasurement(weatherDataCollector.collect("KOL"));
        weatherService.updateMeasurement(weatherDataCollector.collect("DEL"));
    }
}
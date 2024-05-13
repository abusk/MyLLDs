package org.myllds.wether.collector;

import org.myllds.wether.model.WeatherData;

import java.util.HashMap;
import java.util.Map;

public class WeatherDataCollector {
    public static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public WeatherDataCollector() {
        weatherDataMap.put("BNG", new WeatherData(10, 10, 10));
        weatherDataMap.put("KOL", new WeatherData(11, 14, 12));
        weatherDataMap.put("CHE", new WeatherData(15, 14, 14));
        weatherDataMap.put("DEL", new WeatherData(21, 9, 11));
    }

    public WeatherData collect(String location) {
        return weatherDataMap.get(location);
    }
}

package org.myllds.wether.subject;

import org.myllds.wether.model.WeatherData;

public interface Observer {
    public void update(WeatherData weatherData);
}

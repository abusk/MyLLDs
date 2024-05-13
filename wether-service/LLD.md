# LLD For A Weather Service
### Requirements
* Able to Pulls Weather data from an API.
* Multiple clients sees the data in their display systems
* The Service should be scalable
### Entities
* WeatherService
* Observer
* WeatherDataCollector
* WeatherData
* Subject
* CurrentConditionDisplay
* ForecastDisplay
* StatisticsDisplay
### Entity-Relationships
```mermaid
classDiagram
class Observer {
      update(weatherData)
}  
class Display {
        display()
}
class Subject {
        registerObservers(observer);
        removeObservers(observer);
        notifyObservers()
        
}
class WeatherService { 
    observers: Observer
    data: WeatherData
    measurementChanged(wetherData)
} 
class WeatherDataCollector {
    collect()
} 
class CurrentConditionDisplay {
    update()
    display()
}
class ForecastDisplay {
    update()
    display()
} 
class StatisticsDisplay {
    update()
    display() 
}
Subject <|-- WeatherService
WeatherService o-- Observer
WeatherService o-- WeatherData
WeatherDataCollector <-- WeatherService 
Display <|-- CurrentConditionDisplay
Display <|-- ForecastDisplay
Display <|-- StatisticsDisplay
Observer <|-- CurrentConditionDisplay
Observer <|-- ForecastDisplay
Observer <|-- StatisticsDisplay

```
### Identify Design Pattern from Entities-Relationships
* **Observer pattern:** The weather service data collects from collector and all the observers get the update.
### Machine Coding


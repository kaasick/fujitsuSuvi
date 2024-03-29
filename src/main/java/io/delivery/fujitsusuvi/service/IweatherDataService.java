package io.delivery.fujitsusuvi.service;

import io.delivery.fujitsusuvi.exceptions.StationNotFoundException;
import io.delivery.fujitsusuvi.models.WeatherData;

import java.util.List;

//The interface for weatherService

public interface IweatherDataService {

    WeatherData addWeatherData(WeatherData weatherData);

    WeatherData getbyCity(String stationName) throws StationNotFoundException;
    List<WeatherData> getAll();

}

package io.delivery.fujitsusuvi.service;

import io.delivery.fujitsusuvi.exceptions.StationNotFoundException;
import io.delivery.fujitsusuvi.models.WeatherData;

import java.util.List;

//the implementation of the weatherService
public class weatherDataServiceImp implements IweatherDataService {
    @Override
    public WeatherData addWeatherData(WeatherData weatherData) {
        return null;
    }

    @Override
    public WeatherData getbyCity(String stationName) throws StationNotFoundException {
        return null;
    }

    @Override
    public List<WeatherData> getAll() {
        return null;
    }
}

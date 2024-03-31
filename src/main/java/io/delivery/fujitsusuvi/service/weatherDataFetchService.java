package io.delivery.fujitsusuvi.service;

import io.delivery.fujitsusuvi.externalModel.WeatherResponse;
import io.delivery.fujitsusuvi.models.WeatherData;
import io.delivery.fujitsusuvi.repository.WeatherDataRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

// fetching data from https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php
@Service
public class weatherDataFetchService {

    private final WeatherDataRepo weatherDataRepo;
    private final RestTemplate restTemplate;

    public weatherDataFetchService(WeatherDataRepo weatherDataRepo, RestTemplate restTemplate) {
        this.weatherDataRepo = weatherDataRepo;
        this.restTemplate = restTemplate;
    }
    @Scheduled (cron = "${weather.fetch.cron}")
    public void fetchAndStoreWeatherData() {
        String url = "https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php";
        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
        if (weatherResponse != null) {
            processAndStore(weatherResponse);
        }
    }

    private void processAndStore(WeatherResponse weatherResponse) {
        //process and store the fetched data
        //Loop thorugh all 3 of our desired locations
        //and then save the data for it into our database object WeatherData
        weatherResponse.getStations().stream()
                .filter(station -> station.getName().equals("Tallinn-Harku") ||
                        station.getName().equals("Tartu-Tõravere") ||
                        station.getName().equals("Pärnu"))
                .forEach(station -> {
                    WeatherData data = new WeatherData();
                    data.setStationName(station.getName());
                    data.setWmoCode(station.getWmoCode());
                    data.setWeatherPhenomenon(station.getPhenomenon());
                    data.setAirTemperature(station.getAirTemperature());
                    data.setWindSpeed(station.getWindSpeed());
                    data.setTimestamp(LocalDateTime.now());

                    weatherDataRepo.save(data);
                });
    }
}

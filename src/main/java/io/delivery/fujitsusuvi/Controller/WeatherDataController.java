package io.delivery.fujitsusuvi.Controller;

import io.delivery.fujitsusuvi.models.WeatherData;
import io.delivery.fujitsusuvi.repository.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:3000/")

public class WeatherDataController {

    @Autowired
    private WeatherDataRepo weatherDataRepo;

    @GetMapping ("/weatherData")
    public List<WeatherData> fetchWeatherData() {
        return weatherDataRepo.findAll();
    }
}

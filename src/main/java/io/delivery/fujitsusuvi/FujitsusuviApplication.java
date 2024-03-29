package io.delivery.fujitsusuvi;

import io.delivery.fujitsusuvi.models.WeatherData;
import io.delivery.fujitsusuvi.repository.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class FujitsusuviApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FujitsusuviApplication.class, args);
    }

    @Autowired
    private WeatherDataRepo weatherDataRepo;

    @Override
    public void run(String... args) throws Exception {

        //WeatherData test1 = new WeatherData("Tartu", "wmoCode", 10.7, 3.0, "Rainy", LocalDateTime.now());
        WeatherData test1 = WeatherData.builder()
                .stationName("Tartu")
                .wmoCode("wmoCode")
                .airTemperature(11.3)
                .windSpeed(3.0)
                .weatherPhenomenon("rainy")
                .timestamp(LocalDateTime.now())
                .build();

        weatherDataRepo.save(test1);

    }
}

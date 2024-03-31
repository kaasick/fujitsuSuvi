package io.delivery.fujitsusuvi;

import io.delivery.fujitsusuvi.models.WeatherData;
import io.delivery.fujitsusuvi.repository.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@EnableScheduling
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
                .stationName("Test-breakpoint")
                .wmoCode("wmoCode")
                .airTemperature(11.3)
                .windSpeed(3.0)
                .weatherPhenomenon("rainy")
                .timestamp(LocalDateTime.now())
                .build();

        weatherDataRepo.save(test1);

    }
}

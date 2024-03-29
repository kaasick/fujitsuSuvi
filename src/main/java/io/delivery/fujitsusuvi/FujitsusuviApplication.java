package io.delivery.fujitsusuvi;

import io.delivery.fujitsusuvi.repository.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FujitsusuviApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FujitsusuviApplication.class, args);
    }

    @Autowired
    private WeatherDataRepo weatherDataRepo;

    @Override
    public void run(String... args) throws Exception {

    }
}

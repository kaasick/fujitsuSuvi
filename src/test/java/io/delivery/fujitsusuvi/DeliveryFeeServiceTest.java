package io.delivery.fujitsusuvi;

import io.delivery.fujitsusuvi.models.WeatherData;
import io.delivery.fujitsusuvi.repository.WeatherDataRepo;
import io.delivery.fujitsusuvi.service.DeliveryFeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


//To test the rare conditions use cases.

@ExtendWith(MockitoExtension.class)
class DeliveryFeeServiceTest {

    @Mock
    private WeatherDataRepo weatherDataRepo;

    @InjectMocks
    private DeliveryFeeService deliveryFeeService;

    private void testWeatherPhenomenonResponse(WeatherData weatherData) {
        //Defining our own weather
        when(weatherDataRepo.findLatestByStationName(weatherData.getStationName())).thenReturn(Optional.of(weatherData));

        //Doing it in Pärnu, to avoid the trouble of getting Tallinn-Harku from Tallinn and the similar thing in Tartu, because calculateFee takes in our city request.
        try {
            double fee = deliveryFeeService.calculateFee(weatherData.getStationName(), "Bike");
            System.out.println("Phenomenon: " + weatherData.getWeatherPhenomenon() + "|| Response: " + fee + " || Normal bike fee in Pärnu: 2.0");
        } catch (Exception e) {
            System.out.println("Exception " + weatherData.getWeatherPhenomenon() + " || e: " + e.getMessage() + " || city: " + weatherData.getStationName());
        }
    }

    @Test
    void testWeatherConditions() throws Exception {
        //defining all the bad conditions
        WeatherData testGlaze = createWeatherData("glaze");
        WeatherData testHail = createWeatherData("hail");
        WeatherData testSnow = createWeatherData("snow");
        WeatherData testSleet = createWeatherData("sleet");
        WeatherData testThunder = createWeatherData("thunder");
        WeatherData testWind = createWeatherData("high wind", 30.0);
        WeatherData testRain = createWeatherData("rain");

        testWeatherPhenomenonResponse(testSleet);
        testWeatherPhenomenonResponse(testGlaze);
        testWeatherPhenomenonResponse(testHail);
        testWeatherPhenomenonResponse(testSnow);
        testWeatherPhenomenonResponse(testSleet);
        testWeatherPhenomenonResponse(testThunder);
        testWeatherPhenomenonResponse(testWind);
        testWeatherPhenomenonResponse(testRain);
    }

    private WeatherData createWeatherData(String weatherPhenomenon) {
        return createWeatherData(weatherPhenomenon, 3.0); // Default wind speed
    }
    private WeatherData createWeatherData(String weatherPhenomenon, double windSpeed) {
        return WeatherData.builder()
                .stationName("Pärnu")
                .wmoCode("wmoCode")
                .airTemperature(11.3)
                .windSpeed(windSpeed)
                .weatherPhenomenon(weatherPhenomenon)
                .timestamp(LocalDateTime.now())
                .build();
    }

}
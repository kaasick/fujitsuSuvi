package io.delivery.fujitsusuvi.service;

import io.delivery.fujitsusuvi.Cities.City;
import io.delivery.fujitsusuvi.Cities.Pärnu;
import io.delivery.fujitsusuvi.Cities.Tallinn;
import io.delivery.fujitsusuvi.Cities.Tartu;
import io.delivery.fujitsusuvi.Vehicles.Bike;
import io.delivery.fujitsusuvi.Vehicles.Car;
import io.delivery.fujitsusuvi.Vehicles.Scooter;
import io.delivery.fujitsusuvi.Vehicles.Vehicle;
import io.delivery.fujitsusuvi.models.WeatherData;
import io.delivery.fujitsusuvi.repository.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryFeeService {

    @Autowired
    private WeatherDataRepo weatherDataRepo;


    public double calculateFee(String cityQuery, String vehicleType) throws Exception {


        //Defining a vehicle type for our request for a calculation
        //And defining a city
        City city = createCityInstance(cityQuery);
        Vehicle vehicle = createVehicleInstance(city, vehicleType);

        //getting the latest weather data for the request based on the station
        WeatherData latestWeatherData = weatherDataRepo.findLatestByStationName(city.getWeatherStationName())
                .orElseThrow(() -> new IllegalArgumentException("No weather data for this city"));

        //callouts for the methods

        //regionalBaseFee is mapped to the city objects based on the vehicle class given
        double rbf = vehicle.calculateRegionalBaseFee();
        double atef = calculateAirTemperatureExtraFee(vehicle, latestWeatherData);
        double wsef = calculateWindSpeedExtraFee(vehicle, latestWeatherData);
        double wpef = calculateWeatherPhenomenonExtraFee(vehicle, latestWeatherData);

        //returing the sum of these fees
        return rbf + atef + wsef + wpef;
    }
    //Creating the object instances, lowercasing to include both spellings (i.e Car and car)
    private Vehicle createVehicleInstance(City city, String vehicleType) throws Exception {
        switch (vehicleType.toLowerCase()) {
            case "car": return new Car(city);
            case "scooter": return new Scooter(city);
            case "bike": return new Bike(city);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }

    //City instance creating, using both spelling (Tallinn tallinn) to return the station name, from where we fetch the data for the weather
    private City createCityInstance(String stationName) {
        switch (stationName.toLowerCase()) {
            case "tallinn":
                return new Tallinn("Tallinn-Harku");
            case "tartu":
                return new Tartu("Tartu-Tõravere");
            case "pärnu":
                return new Pärnu("Pärnu");
            default:
                throw new IllegalArgumentException("Unsupported city name: " + stationName);
        }
    }

    //Weather data will be extracted and then business rules will be applied to return the extra fee
    //according to the given rules, based on the weather and the vehicle type.
    //if nothing is found, returns 0.0 as in no extra fees are applied.
    private double calculateAirTemperatureExtraFee(Vehicle vehicleType, WeatherData weatherData) {
        //calculated for bike and scooter
        if (vehicleType instanceof Bike || vehicleType instanceof Scooter) {
            double airTemperature = weatherData.getAirTemperature();
            if (airTemperature < -10) return 1.0;
            if (airTemperature >= -10 && airTemperature <= 0) return 0.5;
        }
        return 0.0;
    }

    private double calculateWindSpeedExtraFee(Vehicle vehicleType, WeatherData weatherData) {
        //Only for bike
        if (vehicleType instanceof Bike) {
            double windSpeed = weatherData.getWindSpeed();
            if (windSpeed > 20) throw new IllegalArgumentException("Usage of selected vehicle type is forbidden due to high wind speed");
            if (windSpeed >= 10 && windSpeed <= 20) return 0.5;
        }
        return 0.0;
    }

    private double calculateWeatherPhenomenonExtraFee(Vehicle vehicleType, WeatherData weatherData) {
        //for bike and scooter
        if (vehicleType instanceof Bike || vehicleType instanceof Scooter) {
            String phenomenon = weatherData.getWeatherPhenomenon().toLowerCase();
            //for this exercise, can just do if-elses with .contains("phenomenon needed")
            if (phenomenon.contains("snow") || phenomenon.contains("sleet"))
                return 1.0;
            else if (phenomenon.contains("rain"))
                return 0.5;
            else if (phenomenon.contains("glaze") || phenomenon.contains("hail") || phenomenon.contains("thunder"))
                throw new IllegalArgumentException("Usage of selected vehicle type is forbidden due to dangerous weather conditions");
        }
        return 0.0;
    }
}

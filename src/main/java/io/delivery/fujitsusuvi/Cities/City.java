package io.delivery.fujitsusuvi.Cities;

import lombok.Getter;

import java.util.Map;

//Abstract class for city
//To make it easier, when new cities are wanted to be added
//Defining a map for vehicles types and their fees, i.e car = 4.0, scooter = 3.5
//And a method to get the fee from a city and a vehicle used in that city.
public abstract class City {
    @Getter //lombok getter
    protected String weatherStationName;
    protected Map<String, Double> baseFeesByVehicle;

    public City(String weatherStationName) {
        this.weatherStationName = weatherStationName;
    }

    public double getBaseFeeForVehicle(String vehicleType) {
        return baseFeesByVehicle.getOrDefault(vehicleType.toLowerCase(), 0.0);
    }

}

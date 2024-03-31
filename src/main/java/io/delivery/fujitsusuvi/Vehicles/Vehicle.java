package io.delivery.fujitsusuvi.Vehicles;

import io.delivery.fujitsusuvi.Cities.City;

//Abstract class to set the template for our vehicle types
//Defining the city variable because different fees in different cities
//Defining the method to calculate fees based on which city, where
//values are mapped to the city's class, and here we just define the vehicle type for it, to get the result
public abstract class Vehicle {
    protected City city;

    public Vehicle(City city) {
        this.city = city;
    }

    public abstract double calculateRegionalBaseFee();
}

package io.delivery.fujitsusuvi.Vehicles;

import io.delivery.fujitsusuvi.Cities.City;

public class Bike extends Vehicle {
    public Bike(City city) {
        super(city);
    }

    @Override
    public double calculateRegionalBaseFee() {
        return this.city.getBaseFeeForVehicle("bike");
    }
}

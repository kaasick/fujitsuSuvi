package io.delivery.fujitsusuvi.Vehicles;

import io.delivery.fujitsusuvi.Cities.City;

public class Scooter extends Vehicle {
    public Scooter(City city) {
        super(city);
    }

    @Override
    public double calculateRegionalBaseFee() {
        return this.city.getBaseFeeForVehicle("scooter");
    }
}

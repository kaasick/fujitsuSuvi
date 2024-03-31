package io.delivery.fujitsusuvi.Vehicles;

import io.delivery.fujitsusuvi.Cities.City;

public class Car extends Vehicle {
    public Car(City city) {
        super(city);
    }

    @Override
    public double calculateRegionalBaseFee() {
        return this.city.getBaseFeeForVehicle("car");
    }
}

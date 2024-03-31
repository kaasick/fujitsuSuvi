package io.delivery.fujitsusuvi.Cities;

import java.util.Map;

public class Tartu extends City {
    public Tartu(String weatherStationName) {
        super(weatherStationName);
        baseFeesByVehicle = Map.of(
                "car", 3.5,
                "scooter", 3.0,
                "bike", 2.5
        );
    }
}

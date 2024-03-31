package io.delivery.fujitsusuvi.Cities;

import java.util.Map;

public class Tallinn extends City {

    public Tallinn(String weatherStationName) {
        super(weatherStationName);
        baseFeesByVehicle = Map.of(
                "car", 4.0,
                "scooter", 3.5,
                "bike", 3.0
        );
    }
}

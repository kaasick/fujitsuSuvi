package io.delivery.fujitsusuvi.Cities;

import java.util.Map;

public class Pärnu extends City {
    public Pärnu(String weatherStationName) {
        super(weatherStationName);
        baseFeesByVehicle = Map.of(
            "car", 3.0,
            "scooter", 2.5,
            "bike", 2.0
        );
    }
}

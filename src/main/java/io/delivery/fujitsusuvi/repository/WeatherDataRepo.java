package io.delivery.fujitsusuvi.repository;

import io.delivery.fujitsusuvi.models.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WeatherDataRepo extends JpaRepository<WeatherData, Long> {

    //select * from weather_data where station_name = 'Pärnu' order by timestamp desc limit 1

    //querying the latest weather data based on the given station name
    @Query(value = "select * from weather_data where station_name = :stationName order by timestamp desc limit 1", nativeQuery = true)
    Optional<WeatherData> findLatestByStationName(String stationName);
}

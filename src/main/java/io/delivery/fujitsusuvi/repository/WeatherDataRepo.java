package io.delivery.fujitsusuvi.repository;

import io.delivery.fujitsusuvi.models.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepo extends JpaRepository<WeatherData, Long> {
}

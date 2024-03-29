package io.delivery.fujitsusuvi.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//lombok getters/setter/constructors
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "weatherData")
public class WeatherData {
    //defining the WeatherData object

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "stationName", nullable = false)
    private String stationName;
    @Column (name = "wmoCode")
    private String wmoCode;
    @Column (name = "airTemperature")
    private double airTemperature;
    @Column (name = "windSpeed")
    private double windSpeed;
    @Column (name = "weatherPhenomenon")
    private String weatherPhenomenon;
    @Column (name = "timestamp")
    private LocalDateTime timestamp;

    // Getters, setters, constructors done automatically with lombok


}

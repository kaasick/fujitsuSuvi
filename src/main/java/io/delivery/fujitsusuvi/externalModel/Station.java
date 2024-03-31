package io.delivery.fujitsusuvi.externalModel;

import jakarta.xml.bind.annotation.XmlElement;

import java.time.LocalDateTime;

public class Station {

    private String stationName;
    private String wmoCode;
    private String phenomenon;
    private double airTemperature;
    private double windSpeed;
    private LocalDateTime time;
    // Other fields

    @XmlElement(name = "name")
    public String getName() {
        return stationName;
    }

    public void setName(String name) {
        this.stationName = name;
    }

    @XmlElement(name = "airtemperature")
    public double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }

    @XmlElement(name = "windspeed")
    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @XmlElement (name = "wmocode")
    public String getWmoCode() {
        return wmoCode;
    }

    public void setWmoCode(String wmoCode) {
        this.wmoCode = wmoCode;
    }
    @XmlElement (name = "phenomenon")
    public String getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
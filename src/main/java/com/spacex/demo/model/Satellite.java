package com.spacex.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class Satellite {
    private String noradId;
    private String satName;
    private int satAltitude;
    private int satLong;
    private int satLat;
    private String satOrbit;
    private String satHealth;

    public Satellite(@JsonProperty("noradId") String noradId, @JsonProperty("satName") String satName, @JsonProperty("satAltitude") int satAltitude,
                     @JsonProperty("satLong") int satLong, @JsonProperty("satLat") int satLat, @JsonProperty("satOrbit") String satOrbit, @JsonProperty("satHealth") String satHealth) {
        this.noradId = noradId;
        this.satName = satName;
        this.satAltitude = satAltitude;
        this.satLong = satLong;
        this.satLat = satLat;
        this.satOrbit = satOrbit;
        this.satHealth = satHealth;
    }

    public String getNoradId() {
        return noradId;
    }

    public String getSatName() {
        return satName;
    }

    public int getSatAltitude() {
        return satAltitude;
    }

    public int getSatLong() {
        return satLong;
    }

    public int getSatLat() {
        return satLat;
    }

    public String getSatOrbit() {
        return satOrbit;
    }

    public String getSatHealth() {
        return satHealth;
    }

    public void setSatName(String satName) {
        this.satName = satName;
    }

    public void setSatAltitude(int satAltitude) {
        this.satAltitude = satAltitude;
    }

    public void setSatLong(int satLong) {
        this.satLong = satLong;
    }

    public void setSatLat(int satLat) {
        this.satLat = satLat;
    }

    public void setSatOrbit(String satOrbit) {
        this.satOrbit = satOrbit;
    }

    public void setSatHealth(String satHealth) {
        this.satHealth = satHealth;
    }
}

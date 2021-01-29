package com.spacex.demo.model;

import java.util.Optional;

public class Constellation {
    private String conId;
    private String conName;
    private int conLon;
    private int conLat;

    public Constellation(String conId, String conName, int conLon, int conLat) {
        this.conId = conId;
        this.conName = conName;
        this.conLon = conLon;
        this.conLat = conLat;
    }

    public String getConId() {
        return conId;
    }

    public String getConName() {
        return conName;
    }

    public int getConLon() {
        return conLon;
    }

    public int getConLat() {
        return conLat;
    }

    public void setConId(String conId) {
        this.conId = conId;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public void setConLon(int conLon) {
        this.conLon = conLon;
    }

    public void setConLat(int conLat) {
        this.conLat = conLat;
    }
}

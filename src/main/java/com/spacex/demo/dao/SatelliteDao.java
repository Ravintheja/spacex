package com.spacex.demo.dao;

import com.spacex.demo.model.Constellation;
import com.spacex.demo.model.Satellite;

import java.util.List;
import java.util.Optional;

public interface SatelliteDao {

    default int setPosition(Satellite noradId, Satellite satellite) {
        return 1;
    }

    int setPosition(Satellite satellite);

    List<Satellite> selectAllSatelites();

    int controlOrbit(String noraId, int altitude);

    int addCons(String noradId, String conId);

    int decCons(String noradId);

    Optional<Satellite> getSatellite(String noraId);

    String testSat();
}

package com.spacex.demo.dao;

import com.spacex.demo.model.Constellation;
import com.spacex.demo.model.Satellite;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("satellitedao")
public class FakeSatelliteDataAccessService implements SatelliteDao{

    private static List<Satellite> DB = new ArrayList<>();
    private static List<Constellation> DB2 = new ArrayList<>();
    private String boss;


    @Override
    public int setPosition(Satellite noradId, Satellite satellite) {
        DB.add(new Satellite(satellite.getNoradId(), satellite.getSatName(), satellite.getSatAltitude(), satellite.getSatLong(),
                satellite.getSatLat(), satellite.getSatOrbit(), satellite.getSatHealth()));
        return 1;
    }

    @Override
    public int setPosition(Satellite satellite) {
        //Add sat
        DB.add(satellite);
        Constellation cons = new Constellation("con1", "Scorpio", 69, 96); //test function
        boss = satellite.getSatName(); //test function
        return 1;
    }

    @Override
    public List<Satellite> selectAllSatelites() {
        //Get all Sats
        return DB;
    }

    @Override
    public int controlOrbit(String noradId, int altitude) {
        //Edit Sat
//        return getSatellite(noradId).map(satellite -> {
//            int updateIndex = DB.indexOf(satellite);
//            if (updateIndex >= 0){
//                DB.set(updateIndex,
//                        new Satellite(noradId, update.getSatName(), update.getSatAltitude(), update.getSatLong(),
//                                update.getSatLat(), update.getSatOrbit(), update.getSatHealth())
//                );
//                return 1;
//            }
            return 0;
    }

    @Override
    public int addCons(String noradId, String conId) {
        return getSatellite(noradId).map(satellite -> {
            int updateIndex = DB.indexOf(satellite);
            satellite.setSatLat(35);
            satellite.setSatLong(35);
            if (updateIndex >= 0){
                DB.set(updateIndex,
                        new Satellite(noradId, satellite.getSatName(), satellite.getSatAltitude(), satellite.getSatLong(),
                                satellite.getSatLat(), satellite.getSatOrbit(), satellite.getSatHealth())
                );
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public int decCons(String noradId) {
        return getSatellite(noradId).map(satellite -> {
            int updateIndex = DB.indexOf(satellite);
            satellite.setSatLat(33);
            satellite.setSatLong(34);
            if (updateIndex >= 0){
                DB.set(updateIndex,
                        new Satellite(noradId, satellite.getSatName(), satellite.getSatAltitude(), satellite.getSatLong(),
                                satellite.getSatLat(), satellite.getSatOrbit(), satellite.getSatHealth())
                );
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Satellite> getSatellite(String noradId) {
        //Get specific Sat
        return DB.stream()
                .filter(satellite -> satellite.getNoradId().equals(noradId))
                .findFirst();
    }

    @Override
    public String testSat() {
        //test
        return boss;
    }
}

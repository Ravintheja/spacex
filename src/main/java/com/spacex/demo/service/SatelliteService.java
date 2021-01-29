package com.spacex.demo.service;

import com.spacex.demo.dao.SatelliteDao;
import com.spacex.demo.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SatelliteService {

    private final SatelliteDao satelliteDao;

    @Autowired
    public SatelliteService(@Qualifier("postgres") SatelliteDao satelliteDao){
        this.satelliteDao = satelliteDao;
    }
    public int setPosition(Satellite satellite){
        return satelliteDao.setPosition(satellite);
    }

    public List<Satellite> selectAllSatellites(){
        return satelliteDao.selectAllSatelites();
    }

    public Optional<Satellite> getSatellite(String noraId){
        return satelliteDao.getSatellite(noraId);
    }

    public int controlOrbit(String noraId, int altitude){

        return satelliteDao.controlOrbit(noraId, altitude);
    }

    public int decCons(String noradId) {
        return satelliteDao.decCons(noradId);
    }

    public int addCons(String noradId, String conId) {
        return satelliteDao.addCons(noradId, conId);
    }
}

package com.spacex.demo.api;

import com.spacex.demo.dao.SatelliteDao;
import com.spacex.demo.model.Satellite;
import com.spacex.demo.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/satellite")
@RestController
public class SatelliteController {
    private final SatelliteService satelliteService;

    @Autowired
    public SatelliteController(SatelliteService satelliteService){

        this.satelliteService = satelliteService;
    }

    @PostMapping
    public void setPosition(@RequestBody Satellite satellite){

        satelliteService.setPosition(satellite);
    }

    @GetMapping
    public List<Satellite> selectAllSatellites(){

        return satelliteService.selectAllSatellites();
    }

    @GetMapping(path = "{id}")
    public Satellite getSatellite(@PathVariable("id") String noradId){
        return satelliteService.getSatellite(noradId)
                .orElse(null);
    }

    @PutMapping(path = "conorb/{id}/{alt}")
    public void controlOrbit(@PathVariable("id") String noraId, @PathVariable("alt") int altitude){
        satelliteService.controlOrbit(noraId, altitude);
    }
    @PutMapping(path = "deccons/{id}")
    public void decCons(@PathVariable("id") String noradId) {
        satelliteService.decCons(noradId);
    }

    @PutMapping(path = "addcons/{id}/{conid}")
    public void addCons(@PathVariable("id") String noradId, @PathVariable("conid") String conId) {
        satelliteService.addCons(noradId, conId);
    }
}

package com.spacex.demo.dao;

import com.spacex.demo.model.Constellation;
import com.spacex.demo.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.lang.Math;
import java.util.stream.Stream;

@Repository("postgres")
public class SatelliteDataAccessService implements SatelliteDao{

    private final JdbcTemplate jdbcTemplate;
    private static List<Constellation> con_db = new ArrayList<>();

    @Autowired
    public SatelliteDataAccessService(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
        con_db.add(new Constellation("con1", "Aries", 2460, 3410 ));
        con_db.add(new Constellation("con2", "Taurus", 5943, 9895 ));
        con_db.add(new Constellation("con3", "Gemini", 4963, 1935 ));
        con_db.add(new Constellation("con4", "Cancer", 8531, 8721 ));
        con_db.add(new Constellation("con5", "Leo", 8641, 8136 ));
        con_db.add(new Constellation("con6", "Virgo", 4526, 8654 ));
        con_db.add(new Constellation("con7", "Libra", 2394, 7846));
        con_db.add(new Constellation("con8", "Scorpio", 9743, 4835 ));
        con_db.add(new Constellation("con9", "Sagittarius", 7865, 9431 ));
        con_db.add(new Constellation("con10", "Capricorn", 1465, 6946 ));
        con_db.add(new Constellation("con11", "Aquarius", 8726, 5713));
        con_db.add(new Constellation("con12", "Pisces", 4862, 2449 ));

    }

    @Override
    public int setPosition(Satellite satellite) {
        //Not used anymore
        return 0;
    }

    @Override
    public List<Satellite> selectAllSatelites() {
        final String sql = "SELECT * FROM satellite_tab";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Satellite(resultSet.getString("noradId"), resultSet.getString("satName"),
                    resultSet.getInt("satAltitude"), resultSet.getInt("satLong"),
                    resultSet.getInt("satLat"), resultSet.getString("satOrbit"),
                    resultSet.getString("satHealth"));
        } );
    }

    @Override
    public int controlOrbit(String noradId, int altitude) {
        final String sql = "UPDATE satellite_tab SET satAltitude = ? , satOrbit = ? WHERE noradId = ?";

        String orbit = "parked";

        if(altitude >= 400 && altitude < 600){
            orbit = "service";
        }
        else if(altitude >= 600){
            orbit = "above service";
        }
        else if(altitude < 400 && altitude >= 300){
            orbit = "below service";
        }
        else if(altitude < 300){
            orbit = "low";
        }

        Satellite sat = jdbcTemplate.queryForObject(sql, new Object[]{altitude, orbit, noradId}, (resultSet, i) -> {
            return new Satellite(resultSet.getString("noradId"), resultSet.getString("satName"),
                    resultSet.getInt("satAltitude"), resultSet.getInt("satLong"),
                    resultSet.getInt("satLat"), resultSet.getString("satOrbit"),
                    resultSet.getString("satHealth"));
        } );
        System.out.println(sat);

        return 0;
    }

    @Override
    public int addCons(String noradId, String conId) {
        final String sql = "UPDATE satellite_tab SET satLat = ? , satLong = ? WHERE noradId = ?";

        Iterator itr = con_db.iterator();
        int lat = 1;
        int lon = 1;

        for(int x =1; x<13; x++){
            Constellation conz = (Constellation) itr.next();
            //System.out.println(conz.getConId() +" - "+conId);
            if(conz.getConId().equals(conId)){
               lat= conz.getConLat();
               lon = conz.getConLon();
            }
        }

        Satellite sat = jdbcTemplate.queryForObject(sql, new Object[]{lat, lon, noradId}, (resultSet, i) -> {
            return new Satellite(resultSet.getString("noradId"), resultSet.getString("satName"),
                    resultSet.getInt("satAltitude"), resultSet.getInt("satLong"),
                    resultSet.getInt("satLat"), resultSet.getString("satOrbit"),
                    resultSet.getString("satHealth"));
        } );
        System.out.println(sat);
        return 0;
    }

    @Override
    public int decCons(String noradId) {
        final String sql = "UPDATE satellite_tab SET satLat = ? , satLong = ? WHERE noradId = ?";

        int lat = (int) (Math.random() * 9999);
        int lon = (int) (Math.random() * 9999);

        Satellite sat = jdbcTemplate.queryForObject(sql, new Object[]{lat, lon, noradId}, (resultSet, i) -> {
            return new Satellite(resultSet.getString("noradId"), resultSet.getString("satName"),
                    resultSet.getInt("satAltitude"), resultSet.getInt("satLong"),
                    resultSet.getInt("satLat"), resultSet.getString("satOrbit"),
                    resultSet.getString("satHealth"));
        } );
        System.out.println(sat);
        return 0;
    }

    @Override
    public Optional<Satellite> getSatellite(String noraId) {
        final String sql = "SELECT * FROM satellite_tab WHERE noradId = ?";
        Satellite sat = jdbcTemplate.queryForObject(sql, new Object[]{noraId}, (resultSet, i) -> {
            return new Satellite(resultSet.getString("noradId"), resultSet.getString("satName"),
                    resultSet.getInt("satAltitude"), resultSet.getInt("satLong"),
                    resultSet.getInt("satLat"), resultSet.getString("satOrbit"),
                    resultSet.getString("satHealth"));
        } );
        return Optional.ofNullable(sat);
    }

    @Override
    public String testSat() {
        return null;
    }
}

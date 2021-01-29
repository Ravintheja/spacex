package com.spacex.demo;

import com.spacex.demo.dao.FakeSatelliteDataAccessService;
import com.spacex.demo.model.Satellite;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarlinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarlinkApplication.class, args);
		System.out.println("Starlink Master: ONLINE");
//		FakeSatelliteDataAccessService sat = new FakeSatelliteDataAccessService();
//		Satellite satz = new Satellite("sat2", "Nebula 7", 600, 5000, 4000, "Parked", "Stable");
//		sat.setPosition(satz);
//		System.out.println("Modok: " +  sat.testSat());

	}

}

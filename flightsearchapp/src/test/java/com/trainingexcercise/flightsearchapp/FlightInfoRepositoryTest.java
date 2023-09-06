package com.trainingexcercise.flightsearchapp;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.trainingexcercise.flightsearchapp.model.FlightInfo;
import com.trainingexcercise.flightsearchapp.repository.FlightInfoRepository;

@DataJpaTest
public class FlightInfoRepositoryTest {

	@Autowired
	private FlightInfoRepository flightInfoRepositoryTest;
	
	@BeforeEach
	void intialize_Data() {
		FlightInfo newFlightInfoTest = new FlightInfo();
		newFlightInfoTest.setFlightNumber("F06");
		newFlightInfoTest.setOrigin("SriLanka");
		newFlightInfoTest.setDestination("Thailand");
		newFlightInfoTest.setDuration(null);
		flightInfoRepositoryTest.save(newFlightInfoTest);

	}
	
	@Test
	void findAll_should_return_flightInfo_list() {
		List<FlightInfo> flightInfoTest=flightInfoRepositoryTest.findAll();
		
		assertEquals(7, flightInfoTest.size());
	}
	
	@Test
	void findbyFlightNumber_should_return_flighInfo() {
		FlightInfo flightInfoTest=flightInfoRepositoryTest.findByFlightNumber("F01");
		assertEquals("FlightInfo(id=1, flightNumber=F01, origin=Chennai, destination=Canada, duration=07:02:20)", flightInfoTest.toString());		
	}
	
	@Test
	void save_should_insert_new_flightInfo() {
		FlightInfo newFlightInfoTest = new FlightInfo();
		newFlightInfoTest.setFlightNumber("T01");
		newFlightInfoTest.setOrigin("Tchennai");
		newFlightInfoTest.setDestination("Tcovai");
		newFlightInfoTest.setDuration(null);
		
		FlightInfo newFlightInfo = flightInfoRepositoryTest.save(newFlightInfoTest);
		assertNotNull(newFlightInfo);
        assertEquals("T01", newFlightInfo.getFlightNumber());
		
	}
	
	@Test
    void save_should_update_existing_flightInfo() {
		FlightInfo newFlightInfoTest = new FlightInfo();
		newFlightInfoTest.setFlightNumber("T01");
		newFlightInfoTest.setOrigin("Tchennai");
		newFlightInfoTest.setDestination("Tcovai");
		newFlightInfoTest.setDuration(null);
		FlightInfo newFlightInfo = flightInfoRepositoryTest.save(newFlightInfoTest);
		assertNotNull(newFlightInfo);
		
		//updating info with new details
		FlightInfo updatedFlightInfoTest = flightInfoRepositoryTest.findByFlightNumber("T01");
		updatedFlightInfoTest.setFlightNumber("T05");
		updatedFlightInfoTest.setOrigin("Tcovai");
		updatedFlightInfoTest.setDestination("Tchennai");
		updatedFlightInfoTest.setDuration(null);
		FlightInfo updatedFlightInfo = flightInfoRepositoryTest.save(updatedFlightInfoTest);
		assertNotNull(updatedFlightInfo);
        assertEquals("T05", updatedFlightInfo.getFlightNumber());
	}
	
	@Test
    void search_should_show_flightInfo_by_OriginAndDestination() {

		List<FlightInfo> searchFlightInfoTest = flightInfoRepositoryTest.findByOriginandDestination("SriLanka", "Thailand");
		assertEquals(1, searchFlightInfoTest.size());
	}
}

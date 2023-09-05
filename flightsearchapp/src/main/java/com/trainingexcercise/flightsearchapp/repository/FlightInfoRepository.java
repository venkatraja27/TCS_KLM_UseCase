package com.trainingexcercise.flightsearchapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trainingexcercise.flightsearchapp.model.FlightInfo;


public interface FlightInfoRepository extends JpaRepository<FlightInfo, Integer> {
	FlightInfo findByFlightNumber(String flight_number);

	void deleteByFlightNumber(String flight_number);

	@Query("select f from FlightInfo f where f.origin=:origin AND f.destination=:destination")
	List<FlightInfo> findByOriginandDestination(String origin, String destination);
}

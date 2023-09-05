package com.trainingexcercise.flightsearchapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.trainingexcercise.flightsearchapp.model.FlightInfo;
import com.trainingexcercise.flightsearchapp.service.FlightInfoService;

@RestController
public class FlightInfoController {
	@Autowired
	private FlightInfoService flightInfoService;

	@GetMapping("/FlightInfos")
	public List<FlightInfo> getAllFlightInfos() {
		return flightInfoService.getAllFlightInfos();
	}

	@GetMapping("/FlightInfo/{flight_number}")
	public FlightInfo getFlightInfo(@PathVariable String flight_number) {
		return flightInfoService.getFlightInfo(flight_number);
	}

	@PostMapping("/FlightInfo")
	public FlightInfo createFlightInfo(@RequestBody FlightInfo flightInfo) {
		return flightInfoService.createFlightInfo(flightInfo);
	}

	@PutMapping("/FlightInfo/{flight_number}")
	public FlightInfo updateFlightInfo(@PathVariable String flight_number, @RequestBody FlightInfo flightInfo) {
		return flightInfoService.updateFlightInfo(flight_number, flightInfo);
	}

	@DeleteMapping("/FlightInfo/{flight_number}")
	public void deleteFlightInfo(@PathVariable String flight_number) {
		flightInfoService.deleteFlightInfo(flight_number);
	}

	@GetMapping("/FlightInfo")
	public List<FlightInfo> searchFlightInfo(@RequestParam String origin, @RequestParam String destination) {
		return flightInfoService.searchFlightInfo(origin, destination);
	}
}

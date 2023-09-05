package com.trainingexcercise.flightsearchapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.trainingexcercise.flightsearchapp.model.FlightInfo;
import com.trainingexcercise.flightsearchapp.repository.FlightInfoRepository;

@Service
public class FlightInfoService {
	@Autowired
	private FlightInfoRepository flightInfoRepository;

	public List<FlightInfo> getAllFlightInfos() {
// TODO Auto-generated method stub
		return flightInfoRepository.findAll(Sort.by(Sort.Direction.ASC, "duration"));
	}

	public FlightInfo getFlightInfo(String flight_number) {
// TODO Auto-generated method stub
		return flightInfoRepository.findByFlightNumber(flight_number);
	}

	public FlightInfo createFlightInfo(FlightInfo flightInfo) {
// TODO Auto-generated method stub
		return flightInfoRepository.save(flightInfo);
	}

	public FlightInfo updateFlightInfo(String flight_number, FlightInfo flightInfo) {
// TODO Auto-generated method stub
		FlightInfo flightInfoDetails = flightInfoRepository.findByFlightNumber(flight_number);
		flightInfoDetails.setFlightNumber(flightInfo.getFlightNumber());
		flightInfoDetails.setOrigin(flightInfo.getOrigin());
		flightInfoDetails.setDestination(flightInfo.getDestination());
		flightInfoDetails.setDuration(flightInfo.getDuration());
		FlightInfo updatedFlightInfo = flightInfoRepository.save(flightInfoDetails);
// return flightInfoDetails;
		return updatedFlightInfo;
	}

	public void deleteFlightInfo(String flight_number) {
// TODO Auto-generated method stub
		FlightInfo flightInfoDetails = flightInfoRepository.findByFlightNumber(flight_number);
		flightInfoRepository.delete(flightInfoDetails);
	}

	public List<FlightInfo> searchFlightInfo(String origin, String destination) {
// TODO Auto-generated method stub
		return flightInfoRepository.findByOriginandDestination(origin, destination);
	}
}

package com.trainingexcercise.flightsearchapp.model;

import java.sql.Time;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "flight_info")
public class FlightInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "flight_number")
	private String flightNumber;
	@Column(name = "origin")
	private String origin;
	@Column(name = "destination")
	private String destination;
	@Column(name = "duration")
	private Time duration;
}

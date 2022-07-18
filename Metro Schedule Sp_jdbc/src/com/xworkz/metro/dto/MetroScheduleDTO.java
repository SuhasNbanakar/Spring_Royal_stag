package com.xworkz.metro.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetroScheduleDTO {

	// id,station,platform,trainNo,dateAndtime,passengerName,
	// destination,ticketPrice,duration

	private int id;
	private String stationName;
	private int platform;
	private int trainNo;
	private LocalDateTime dateAndTime;
	private String passengerName;
	private String destination;
	private double ticketPrice;
	private LocalTime duration;

}

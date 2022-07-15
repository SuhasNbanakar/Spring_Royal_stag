package com.xworkz.flight.dto.booking;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class FlightBookingDTO {

	@NonNull
	private int id;
	@NonNull
	private String passengerName;
	@NonNull
	private boolean international;
	@NonNull
	private String passportNo;
	@NonNull
	private String airline;
	@NonNull
	private String boarding;
	@NonNull
	private String destination;
	@NonNull
	private double ticketPrice;
	@NonNull
	private LocalDateTime travelDateAndTime;
	@NonNull
	private double gstPercentage;
	private double totalPrice;

}

package com.xworkz.flight.service.booking;

import com.xworkz.flight.dto.booking.FlightBookingDTO;
import com.xworkz.flight.exception.InvalidDataException;

public interface FlightBookingService {

	boolean validateAndSave(FlightBookingDTO bookingDTO) throws InvalidDataException;

}

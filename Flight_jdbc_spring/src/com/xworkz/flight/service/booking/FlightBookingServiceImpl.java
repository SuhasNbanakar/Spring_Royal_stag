package com.xworkz.flight.service.booking;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.xworkz.flight.dao.booking.FlightBookingDAO;
import com.xworkz.flight.dto.booking.FlightBookingDTO;
import com.xworkz.flight.exception.InvalidDataException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FlightBookingServiceImpl implements FlightBookingService {

	private FlightBookingDAO dao;

	@Override
	public boolean validateAndSave(FlightBookingDTO bookingDTO) throws InvalidDataException {
		if (bookingDTO != null) {
			int id = bookingDTO.getId();
			String name = bookingDTO.getPassengerName();
			boolean national = bookingDTO.isInternational();
			String pass = bookingDTO.getPassportNo();
			String airline = bookingDTO.getAirline();
			String boarding = bookingDTO.getBoarding();
			String destination = bookingDTO.getDestination();
			double price = bookingDTO.getTicketPrice();
			LocalDateTime dateAndTime = bookingDTO.getTravelDateAndTime();
			double percentage = bookingDTO.getGstPercentage();

			if (name != null && name.length() > 3 && name.length() < 40 ) {
				System.out.println("PassengerName is valid");
			} else {
				System.err.println("PassengerName is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (pass != null && pass.length() >= 8 && !pass.matches(".*[!@#$%^&*()_+{}><.;,<>].*")) {
				System.out.println("PassportNo is valid");
			} else {
				System.err.println("PassportNo is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (airline != null && airline.length() > 3 && airline.length() < 40 && !airline.matches("")) {
				System.out.println("Airline is valid");
			} else {
				System.err.println("Airline is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (boarding != null && boarding.length() > 3 && boarding.length() < 40 && !boarding.matches("")) {
				System.out.println("Boarding is valid");
			} else {
				System.err.println("Boarding is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (destination != null && destination.length() > 3 && destination.length() < 40
					&& !destination.matches("")) {
				System.out.println("Destination is valid");
			} else {
				System.err.println("Destination is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (price > 1000) {
				System.out.println("TicketPrice is valid");
			} else {
				System.err.println("TicketPrice is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (percentage > 0) {
				if (national == true) {
					System.out.println("add 25% gst");
					bookingDTO.setGstPercentage(25d);
				}
				if (national == false) {
					System.out.println("add 12% gst");
					bookingDTO.setGstPercentage(12d);
				}
			} else {
				System.err.println("gstpercentage is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			double totalPrice = price + (price * (percentage / 100));
			bookingDTO.setTotalPrice(totalPrice);

			boolean saved = dao.save(bookingDTO);
			return saved;
		}
		return false;
	}

}

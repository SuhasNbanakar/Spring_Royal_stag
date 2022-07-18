package com.xworkz.metro.service;

import org.springframework.stereotype.Component;

import com.xworkz.metro.dao.MetroScheduleDAO;
import com.xworkz.metro.dto.MetroScheduleDTO;
import com.xworkz.metro.exception.InvalidDataException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MetroScheduleServiceImpl implements MetroScheduleService {
	private MetroScheduleDAO dao;

	@Override
	public boolean validateAndSave(MetroScheduleDTO scheduleDTO) throws InvalidDataException {
		if (scheduleDTO != null) {
			// id,station,platform,trainNo,dateAndtime,passengerName,
			// destination,ticketPrice,duration
			int id = scheduleDTO.getId();
			String name = scheduleDTO.getStationName();
			int platform = scheduleDTO.getPlatform();
			int trainNO = scheduleDTO.getTrainNo();
			// LocalDateTime dateAndTime = scheduleDTO.getDateAndTime();
			String passengerName = scheduleDTO.getPassengerName();
			String destination = scheduleDTO.getDestination();
			double price = scheduleDTO.getTicketPrice();
			// LocalTime duration = scheduleDTO.getDuration();

			if (id > 0) {
				System.out.println("id is valid");
			} else {
				System.err.println("id is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (name != null && name.length() > 3 && name.length() < 40
					&& !name.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("name is valid");
			} else {
				System.err.println("name is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (platform > 0) {
				System.out.println("platform is valid");
			} else {
				System.err.println("platform is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (trainNO > 0) {
				System.out.println("trainNO is valid");
			} else {
				System.err.println("trainNO is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (passengerName != null && passengerName.length() > 3 && passengerName.length() < 40
					&& !passengerName.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("passengerName is valid");
			} else {
				System.err.println("passengerName is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (destination != null && destination.length() > 3 && destination.length() < 40
					&& !destination.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("destination is valid");
			} else {
				System.err.println("destination is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (price > 10) {
				System.out.println("price is valid");
			} else {
				System.err.println("price is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			return this.dao.save(scheduleDTO);

		}

		return false;
	}

}

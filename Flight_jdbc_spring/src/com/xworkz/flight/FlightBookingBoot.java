package com.xworkz.flight;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.flight.configure.booking.SpringConfigure;
import com.xworkz.flight.dto.booking.FlightBookingDTO;
import com.xworkz.flight.exception.InvalidDataException;
import com.xworkz.flight.service.booking.FlightBookingService;

public class FlightBookingBoot {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure.class);

		FlightBookingService service = context.getBean(FlightBookingService.class);

		FlightBookingDTO dto = new FlightBookingDTO(0, "Laxmi_M_K", false, "V7126972", "Air India", "Bengalure", "Canada",
				75000d, LocalDateTime.of(2022, 10, 22, 10, 30), 25);
		try {
			boolean save = service.validateAndSave(dto);
			System.out.println(save);
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}

	}

}

package com.xworkz.metro;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.metro.configure.SpringConfigure;
import com.xworkz.metro.dto.MetroScheduleDTO;
import com.xworkz.metro.exception.InvalidDataException;
import com.xworkz.metro.service.MetroScheduleService;

public class MetroScheduleRunner {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure.class);

		MetroScheduleService service = context.getBean(MetroScheduleService.class);

		MetroScheduleDTO dto = new MetroScheduleDTO(1, "Banshankri", 1, 7068, LocalDateTime.of(2022, 10, 10, 10, 30),
				"Ranju", "kengeri", 40d, LocalTime.of(2, 10));
		;
		try {
			boolean save = service.validateAndSave(dto);
			System.out.println(save);
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}
	}

}

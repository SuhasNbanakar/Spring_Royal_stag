package com.xworkz.bbmp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.bbmp.configure.SpringConfigure;
import com.xworkz.bbmp.dto.BBMPWardDTO;
import com.xworkz.bbmp.exception.InvalidDataException;
import com.xworkz.bbmp.service.BBMPWardService;

public class BBMPCalling {

	public static void main(String[] agrs) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure.class);

		BBMPWardService wardService = context.getBean(BBMPWardService.class);

		// id,wardNo,wardName,corporator,MLA,budget, spent,remanining

		BBMPWardDTO dto = new BBMPWardDTO(1, 22, "BTM Bng", "Suhas", "Laxmi", 25000d, 19000d);
		try {
			boolean save = wardService.validateAndSave(dto);
			System.out.println(save);
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}
	}

}

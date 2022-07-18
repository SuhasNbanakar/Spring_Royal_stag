package com.xworkz.online;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.online.configure.SpringConfigure;
import com.xworkz.online.dto.OnlineShoppingDTO;
import com.xworkz.online.exception.InvalidDataException;
import com.xworkz.online.service.OnlineShoppingService;

public class OnlineShoppingBoot {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigure.class);

		OnlineShoppingService service = context.getBean(OnlineShoppingService.class);

		OnlineShoppingDTO dto = new OnlineShoppingDTO(0, null, 0, null, 0, 0);
		try {
			boolean save = service.validateAndSave(dto);
			System.out.println(save);
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}
	}

}

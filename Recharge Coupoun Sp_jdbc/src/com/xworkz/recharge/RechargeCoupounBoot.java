package com.xworkz.recharge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xworkz.recharge.configure.SpringConfigure;
import com.xworkz.recharge.dto.RechargeCoupounDTO;
import com.xworkz.recharge.exception.InvalidDataException;
import com.xworkz.recharge.service.RechargeCoupounService;

public class RechargeCoupounBoot {

	public static void main(String[] args) {

		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfigure.class);
		
		RechargeCoupounService service=context.getBean(RechargeCoupounService.class);
		
		RechargeCoupounDTO coupounDTO=new RechargeCoupounDTO(0, null, 0, 0, null, null, false);
		try {
			service.validateAndSave(null);
		} catch (InvalidDataException e) {
			e.printStackTrace();
		}
	}

}

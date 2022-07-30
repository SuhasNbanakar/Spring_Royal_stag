package com.xworkz.krishana.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class TestController {

	public TestController() {

		System.out.println("create Test controller ");
	}
	@RequestMapping("/call")
	public String onTest() {
		System.out.println("running onTest");
		return "index.html";
		
	}

}

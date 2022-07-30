package com.xworkz.ott.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ContactController {

	public ContactController() {
		System.out.println("contact controller is born..!");
	}

	@PostMapping("/contact.do")
	public String onContact() {
		System.out.println("onContact method is born..!");
		return "contact.html";
	}
}

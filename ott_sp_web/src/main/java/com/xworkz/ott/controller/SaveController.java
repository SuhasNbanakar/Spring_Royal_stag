package com.xworkz.ott.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.ott.dto.OttDTO;
import com.xworkz.ott.service.OttService;

@Component
@RequestMapping("/")
public class SaveController {
	@Autowired
	private OttService service;

	public SaveController() {
		System.out.println("save controller is born..!");
	}

	@PostMapping("/save.do")
	public String onSave(OttDTO dto) {
		System.out.println("onSave method is born..!");
//		OttDAO dao = new OttDAOImpl();
//		OttService service = new OttServiceImpl(dao);
		boolean save = service.validateAndSave(dto);
		System.out.println(save);

		return "index.html";
	}
}

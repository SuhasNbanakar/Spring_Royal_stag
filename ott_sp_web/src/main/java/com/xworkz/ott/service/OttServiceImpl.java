package com.xworkz.ott.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.ott.dao.OttDAO;
import com.xworkz.ott.dto.OttDTO;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OttServiceImpl implements OttService {

	@Autowired
	private OttDAO dao;

	@Override
	public boolean validateAndSave(OttDTO ottDTO) {
		System.out.println("valiodate and save method is running");
		return this.dao.save(ottDTO);
	}

}

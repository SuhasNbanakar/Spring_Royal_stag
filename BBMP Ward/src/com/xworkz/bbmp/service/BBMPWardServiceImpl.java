package com.xworkz.bbmp.service;

import org.springframework.stereotype.Component;

import com.xworkz.bbmp.dao.BBMPWardDAO;
import com.xworkz.bbmp.dto.BBMPWardDTO;
import com.xworkz.bbmp.exception.InvalidDataException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BBMPWardServiceImpl implements BBMPWardService {

	private BBMPWardDAO dao;

	@Override
	public boolean validateAndSave(BBMPWardDTO wardDTO) throws InvalidDataException {
		if (wardDTO != null) {

			int id = wardDTO.getId();
			int wardNo = wardDTO.getWardNo();
			String wardName = wardDTO.getWardName();
			String corporatorName = wardDTO.getCorporatorName();
			String mla = wardDTO.getMla();
			double budge = wardDTO.getBudget();
			double spent = wardDTO.getSpent();

			if (id > 0) {
				System.out.println("id is valid");
			} else {
				System.err.println("id is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (wardNo > 0) {
				System.out.println("wardNo is valid");
			} else {
				System.err.println("wardNo is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (wardName != null && wardName.length() > 3 && wardName.length() < 40
					&& !wardName.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("wardName is valid");
			} else {
				System.err.println("wardName is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (corporatorName != null && corporatorName.length() > 3 && corporatorName.length() < 40
					&& !corporatorName.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("corporatorName is valid");
			} else {
				System.err.println("corporatorName is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (mla != null && mla.length() > 3 && mla.length() < 40
					&& !mla.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("mla is valid");
			} else {
				System.err.println("mla is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (budge > 10000) {
				System.out.println("budge is valid");
			} else {
				System.err.println("budge is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (spent > (budge /2)) {
				System.out.println("spent is valid");
			} else {
				System.err.println("spent is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			double remaing = budge - spent;
			wardDTO.setRemaing(remaing);

			return this.dao.save(wardDTO);
		}

		return false;
	}

}

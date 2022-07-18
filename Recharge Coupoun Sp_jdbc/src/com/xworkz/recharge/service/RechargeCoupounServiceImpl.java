package com.xworkz.recharge.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.xworkz.recharge.dao.RechargeCoupounDAO;
import com.xworkz.recharge.dto.RechargeCoupounDTO;
import com.xworkz.recharge.exception.InvalidDataException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RechargeCoupounServiceImpl implements RechargeCoupounService {

	private RechargeCoupounDAO dao;

	@Override
	public boolean validateAndSave(RechargeCoupounDTO dto) throws InvalidDataException {
		// int id,String name,double discount, double cash,String code,
		// localdate validityDate,boolean free

		if (dto != null) {
			int id = dto.getId();
			String name = dto.getName();
			double discount = dto.getDiscount();
			double cash = dto.getCash();
			String code = dto.getCode();
			LocalDate validty = dto.getValidtyDate();

			if (id > 0) {
				System.out.println("id is valid");
			} else {
				System.err.println("id is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (name != null && name.length() > 3 && name.length() < 40
					&& !name.matches(".*[[0-9],!@#$%^&*()_+,.;<>:'{}[]].*")) {
				System.out.println("name is valid");
			} else {
				System.err.println("name is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (discount > 15) {
				System.out.println("discount is valid");
			} else {
				System.err.println("discount is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (cash > 99) {
				System.out.println("cash is valid");
			} else {
				System.err.println("cash is invalid ");
				throw new InvalidDataException("Enter the correct data");

			}
			if (code != null && code.length() > 3 && code.length() < 10 && code.matches("*#")) {
				System.out.println("code is valid");
			} else {
				System.err.println("code is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (validty != LocalDate.now()) {
				System.out.println("validty is valid");
			} else {
				System.err.println("validty is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			return this.dao.save(dto);

		}

		return false;
	}

}

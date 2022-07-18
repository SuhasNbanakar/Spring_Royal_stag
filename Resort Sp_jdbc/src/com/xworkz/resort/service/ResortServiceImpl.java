package com.xworkz.resort.service;

import org.springframework.stereotype.Component;

import com.xworkz.resort.dao.ResortDAO;
import com.xworkz.resort.dto.ResortDTO;
import com.xworkz.resort.exception.InvalidDataException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ResortServiceImpl implements ResortService {
	private ResortDAO dao;

	@Override
	public boolean validateAndSave(ResortDTO resortDTO) throws InvalidDataException {
		if (resortDTO != null) {
			String name = resortDTO.getName();
			String ownerName = resortDTO.getOwnerName();
			double price = resortDTO.getEntrencePrice();
			double gstP = resortDTO.getGstPercentage();

			if (name != null && name.length() > 3 && name.length() < 40
					&& !name.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("name is valid");
			} else {
				System.err.println("name is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (ownerName != null && ownerName.length() > 3 && ownerName.length() < 40
					&& !ownerName.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("ownerName is valid");
			} else {
				System.err.println("ownerName is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (price > 2000) {
				System.out.println("price is valid");
			} else {
				System.err.println("price is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			if (gstP > 8) {
				System.out.println("gst is valid");
			} else {
				System.err.println("gst is invalid");
				throw new InvalidDataException("Enter the correct data");

			}
			double totalprice = price + (price * (gstP / 100));
			resortDTO.setTotalPrice(totalprice);

			return this.dao.save(resortDTO);
		}

		return false;
	}

}

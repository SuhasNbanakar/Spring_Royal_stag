package com.xworkz.online.service;

import org.springframework.stereotype.Component;

import com.xworkz.online.dao.OnlineShoppingDAO;
import com.xworkz.online.dto.OnlineShoppingDTO;
import com.xworkz.online.exception.InvalidDataException;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OnlineShoppingServiceImpl implements OnlineShoppingService {
	private OnlineShoppingDAO dao;

	@Override
	public boolean validateAndSave(OnlineShoppingDTO shoppingDTO) throws InvalidDataException {
		if (shoppingDTO != null) {
			// i id,s product,d price,s type,i quantity,d discount,d gst,d paying
			String productName = shoppingDTO.getProductName();
			double price = shoppingDTO.getPrice();
			String type = shoppingDTO.getType();
			int quantity = shoppingDTO.getQuantity();
			double discount = shoppingDTO.getDiscount();

			if (productName != null && productName.length() > 3 && productName.length() < 40
					&& !productName.matches(".*[[0-9],!@#$%^&*()_+<>,.;'{}].*")) {
				System.out.println("productName is valid");
			} else {
				System.err.println("productName is invalid");
				throw new InvalidDataException("Enter the correct data");
			}
			if (price > 1000) {
				System.out.println("price is valid");
			} else {
				System.err.println("price is invalid");
			}
			if ("electronis".equals(type)) {
				shoppingDTO.setGstPercentage(18d);
			}
			if ("food".equals(type)) {
				shoppingDTO.setGstPercentage(5d);
			}
			if ("medicine".equals(type)) {
				shoppingDTO.setGstPercentage(12d);
			}
			if ("furniture".equals(type)) {
				shoppingDTO.setGstPercentage(8d);
			} else {
				System.err.println("type is invalid");
			}
			if (quantity > 5) {
				System.out.println("quantity is valid");
				shoppingDTO.setDiscount(30d);

			} else {
				System.err.println("quantity is invalid");
			}
			double materialprice = price - (price * (discount / 100));
			double paying = materialprice + (materialprice * (shoppingDTO.getGstPercentage() / 100));
			shoppingDTO.setPaying(paying);

			return this.dao.save(shoppingDTO);
		}
		return false;
	}

}

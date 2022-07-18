package com.xworkz.online.service;

import com.xworkz.online.dto.OnlineShoppingDTO;
import com.xworkz.online.exception.InvalidDataException;

public interface OnlineShoppingService {

	boolean validateAndSave(OnlineShoppingDTO shoppingDTO) throws InvalidDataException;

}

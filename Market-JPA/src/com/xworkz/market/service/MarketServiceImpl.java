package com.xworkz.market.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.market.dao.MarketDAO;
import com.xworkz.market.entityt.MarketEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MarketServiceImpl implements MarketService {
	private MarketDAO dao;

	@Override
	public boolean validateAndSave(MarketEntity entity) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();
		Set<ConstraintViolation<MarketEntity>> temp = validator.validate(entity);
		if (temp.size() > 0) {
			System.err.println("entity is invalid");
		} else {
			System.out.println("entity is valid");
			return dao.save(entity);
		}
		return false;
	}

}

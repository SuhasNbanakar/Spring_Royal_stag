package com.xworkz.resort.service;

import com.xworkz.resort.dto.ResortDTO;
import com.xworkz.resort.exception.InvalidDataException;

public interface ResortService {
	
	boolean validateAndSave(ResortDTO resortDTO) throws InvalidDataException;

}

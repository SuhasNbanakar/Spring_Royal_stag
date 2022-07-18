package com.xworkz.recharge.service;

import com.xworkz.recharge.dto.RechargeCoupounDTO;
import com.xworkz.recharge.exception.InvalidDataException;

public interface RechargeCoupounService {
	
	boolean validateAndSave(RechargeCoupounDTO dto) throws InvalidDataException;

}

package com.xworkz.bbmp.service;

import com.xworkz.bbmp.dto.BBMPWardDTO;
import com.xworkz.bbmp.exception.InvalidDataException;

public interface BBMPWardService {

	boolean validateAndSave(BBMPWardDTO wardDTO)throws InvalidDataException;
}

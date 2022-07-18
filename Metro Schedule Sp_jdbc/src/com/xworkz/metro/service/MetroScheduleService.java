package com.xworkz.metro.service;

import com.xworkz.metro.dto.MetroScheduleDTO;
import com.xworkz.metro.exception.InvalidDataException;

public interface MetroScheduleService {

	boolean validateAndSave(MetroScheduleDTO scheduleDTO) throws InvalidDataException;

}

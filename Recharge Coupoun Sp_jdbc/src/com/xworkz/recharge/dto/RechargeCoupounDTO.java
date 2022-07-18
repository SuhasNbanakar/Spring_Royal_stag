package com.xworkz.recharge.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RechargeCoupounDTO {
	
	//    int id,String name,double discount, double cash,String code,localdate validityDate,boolean free

	private int id;
	private String name;
	private double discount;
	private double cash;
	private String code;
	private LocalDate validtyDate;
	private boolean free;

}

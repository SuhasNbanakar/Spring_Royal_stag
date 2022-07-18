package com.xworkz.bbmp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BBMPWardDTO {

	// id,wardNo,wardName,corporator,MLA,budget, spent,remanining
	@NonNull
	private int id;
	@NonNull
	private int wardNo;
	@NonNull
	private String wardName;
	@NonNull
	private String corporatorName;
	@NonNull
	private String mla;
	@NonNull
	private double budget;
	@NonNull
	private double spent;
	private double remaing;

}

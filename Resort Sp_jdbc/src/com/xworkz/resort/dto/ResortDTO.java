package com.xworkz.resort.dto;

import java.sql.Time;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ResortDTO {
	@NonNull
	private int id;
	@NonNull
	private String name;
	@NonNull
	private String ownerName;
	@NonNull
	private LocalTime openTime;
	@NonNull
	private LocalTime closeTime;
	@NonNull
	private double entrencePrice;
	@NonNull
	private double gstPercentage;
	private double totalPrice;

}

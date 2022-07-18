package com.xworkz.online.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OnlineShoppingDTO {

	// id,product,price,type,quantity,discount,gst,paying
	@NonNull
	private int id;
	@NonNull
	private String productName;
	@NonNull
	private double price;
	@NonNull
	private String type;
	@NonNull
	private int quantity;
	@NonNull
	private double discount;
	private double gstPercentage;
	private double paying;

}

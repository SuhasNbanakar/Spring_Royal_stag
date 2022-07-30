package com.xworkz.ott.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OttDTO {

	private String ott;
	private String region;
	private String language;
	private String pack;
	private String user;
	private int since;
	private boolean status;

}

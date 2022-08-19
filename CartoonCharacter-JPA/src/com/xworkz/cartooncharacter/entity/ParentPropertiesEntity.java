package com.xworkz.cartooncharacter.entity;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class ParentPropertiesEntity {
	private String createdBy;
	private String updatedBy;
	private LocalDate createdDate;
	private LocalDate updatedDate;

	public ParentPropertiesEntity(String createdBy, String updatedBy, LocalDate createdDate, LocalDate updatedDate) {
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
}

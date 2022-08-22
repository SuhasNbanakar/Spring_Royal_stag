package com.xworkz.market.entityt;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class ParentPropertiesEntity {
	@NotNull
	@Size(min = 3, max = 20, message = "createdBy is invalid")
	private String createdBy;
	@NotNull
	@Size(min = 3, max = 20, message = "updatedBy is invalid")
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

package com.xworkz.freedomfighter.entity;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class ParentEntity {

	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

	public ParentEntity(String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate) {
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

}

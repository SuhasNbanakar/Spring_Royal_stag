package com.xworkz.freedomfighter.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "freedom_fighter")
public class FreedomFighterEntity extends ParentEntity {

	@Id
//	@GenericGenerator(name = "boss", strategy = "increment")
//	@GeneratedValue(generator = "boss")
	private int id;
	private String name;
	private LocalDate dateOfBirth;
	private LocalDate deathDate;
	private String gender;
	private String birthLocation;

	public FreedomFighterEntity(int id, String name, LocalDate dateOfBirth, LocalDate deathDate, String gender,
			String birthLocation, String createdBy, String updatedBy, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		super(createdBy, updatedBy, createdDate, updatedDate);
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.deathDate = deathDate;
		this.gender = gender;
		this.birthLocation = birthLocation;
	}
}

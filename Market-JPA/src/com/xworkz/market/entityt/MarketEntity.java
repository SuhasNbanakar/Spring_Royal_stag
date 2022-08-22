package com.xworkz.market.entityt;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@Table(name = "market")

public class MarketEntity extends ParentPropertiesEntity {

	@Id
	@GenericGenerator(name = "baby", strategy = "increment")
	@GeneratedValue(generator = "baby")
	@NotNull(message = "id is invalid")
	private int id;
	@NotNull
	@Size(min = 3, max = 20, message = "type is invalid")
	private String type;
	@NotNull
	@Size(min =3, max = 20, message = "location is invalid")
	private String location;
	private double capacity;
	private LocalDate establishDate;

	public MarketEntity(String type, String location, double capacity, LocalDate establishDate, String createdBy,
			String updatedBy, LocalDate createdDate, LocalDate updatedDate) {
		super(createdBy, updatedBy, createdDate, updatedDate);
		this.type = type;
		this.location = location;
		this.capacity = capacity;
		this.establishDate = establishDate;
	}

}

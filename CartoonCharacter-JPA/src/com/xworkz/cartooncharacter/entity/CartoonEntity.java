package com.xworkz.cartooncharacter.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "cartoon_character")
@NamedQueries({
	@NamedQuery(name = "findByName", query = "select cartoon from CartoonEntity cartoon where cartoon.name=:nm"),
		@NamedQuery(name = "total", query = "select count(*) from CartoonEntity"),		@NamedQuery(name = "findByMaxCreatedDate", query = "select max(createdDatea),cartoon from CartoonEntity cartoon"),
//		@NamedQuery(name = "findByNameAndCountryAndGenderAndAuthor", query = "select cartoon from CartoonEntity cartoon where cartoon.name=:ne and cartoon.country=:co and cartoon.gender=:ge and cartoon.author=ae"),
//		@NamedQuery(name = "findAuthorByName", query = "select cartoon.author from CartoonEntity cartoon where cartoon.name:nam"),
//		@NamedQuery(name = "findNameAndCountryByAuthor", query = "select cartoon.name,cartoon.country from CartoonEntity cartoon where cartoon.author=:au"),
//		@NamedQuery(name = "findCreatedDateByAuthor", query = "select cartoon.createdDate from CartoonEntity cartoon where cartoon.author=:aut"),
//		@NamedQuery(name = "updateAuthorByName", query = "update CartoonEntity cartoon set cartoon.author=:auth where cartoon.name=:name"),
//		@NamedQuery(name = "updateTypeByName", query = "update CartoonEntity cartoon set cartoon.type=:ty where cartoon.name=:ns"),
//		@NamedQuery(name = "deleteByName", query = "delete from CartoonEntity cartoon where cartoon.name=:mn "),
//		@NamedQuery(name = "findAll", query = "select cartoon from CartoonEntity cartoon"),
//		@NamedQuery(name = "findAllByAuthor", query = "select cartoon from CartoonEntity cartoon where cartoon.author=:at"),
//		@NamedQuery(name = "findAllByAuthorAndGender", query = "select cartoon from CartoonEntity cartoon where cartoon.author=:ah,and cartoon.gender=:gn"),
//		@NamedQuery(name = "findAllName", query = "select cartoon.name from CartoonEntity cartoon"),
//		@NamedQuery(name = "findAllCountry", query = "select cartoon.country from CartoonEntity cartoon"),
//		@NamedQuery(name = "findAllNameAndCountry", query = "select cartoon.name,cartoon.country from CartoonEntity cartoon"),
//		@NamedQuery(name = "findAllNameAndCountryAndAuthor", query = "select cartoon.name,cartoon.country,cartoon.author from CartoonEntity cartoon"),

})
public class CartoonEntity extends ParentPropertiesEntity {
	@Id
	@GenericGenerator(name = "suvii", strategy = "increment")
	@GeneratedValue(generator = "suvii")
	private int id;
	private String name;
	private String country;
	private String gender;
	private String author;
	private String type;

	public CartoonEntity(String name, String country, String gender, String author, String type, String createdBy,
			String updatedBy, LocalDate createdDate, LocalDate updatedDate) {
		super(createdBy, updatedBy, createdDate, updatedDate);
		this.name = name;
		this.country = country;
		this.gender = gender;
		this.author = author;
		this.type = type;
	}

}

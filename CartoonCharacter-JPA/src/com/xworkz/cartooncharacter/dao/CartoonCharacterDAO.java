package com.xworkz.cartooncharacter.dao;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import com.xworkz.cartooncharacter.entity.CartoonEntity;

public interface CartoonCharacterDAO {

	boolean saveAll(List<CartoonEntity> entity);// 10 cartoons

	CartoonEntity findByName(String name);

	Integer total();

	CartoonEntity findByMaxCreatedDate();

	CartoonEntity findByNameAndCountryAndGenderAndAuthor(String name, String country, String gender,
			String author);

	String findAuthorByName(String name);

	Object[] findNameAndCountryByAuthor(String author);

	LocalDateTime findCreatedDateByAuthor(String author);

	void updateAuthorByName(String newAuthor, String name);

	void updateTypeByName(String type,String name);

	void deleteByName(String name);

	default List<CartoonEntity> findAll() {
		return Collections.emptyList();
	}

	default List<CartoonEntity> findAllByAuthor(String author) {
		return Collections.emptyList();
	}

	default List<CartoonEntity> findAllByAuthorAndGender(String author, String gender) {
		return Collections.emptyList();
	}

	default List<String> findAllName() {
		return Collections.emptyList();
	}

	default List<String> findAllCountry() {
		return Collections.emptyList();
	}

	default List<Object[]> findAllNameAndCountry() {
		return Collections.emptyList();
	}

	default List<Object[]> findAllNameAndCountryAndAuthor() {
		return Collections.emptyList();
	}

}

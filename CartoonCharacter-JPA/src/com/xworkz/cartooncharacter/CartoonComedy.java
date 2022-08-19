package com.xworkz.cartooncharacter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.cartooncharacter.dao.CartoonCharacterDAO;
import com.xworkz.cartooncharacter.dao.CartoonCharacterDAOImpl;
import com.xworkz.cartooncharacter.entity.CartoonEntity;

public class CartoonComedy {

	public static void main(String[] args) {

		CartoonEntity entity1 = new CartoonEntity("Betty Boop", "India", "male", "suhas", "Comdey", "suhas", "suhas",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity2 = new CartoonEntity("Bugs Bunny", "India", "male", "sirsi", "Comdey", "suhas", "sirsi",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity3 = new CartoonEntity("Charlie Brown", "USA", "male", "Ramesh", "Comdey", "suhas", "Ramesh",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity4 = new CartoonEntity("Daffy Duck", "India", "female", "chinni", "Comdey", "suhas", "chinni",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity5 = new CartoonEntity("Dennis", "India", "male", "sunil", "Comdey", "suhas", "sunil",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity6 = new CartoonEntity("Donald duck", "India", "male", "sanju", "Comdey", "suhas", "sanju",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity7 = new CartoonEntity("Garfield", "Germany", "male", "Lucky", "Comdey", "suhas", "Lucky",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity8 = new CartoonEntity("Micky mouse", "Nz", "male", "Rani", "Comdey", "suhas", "Rani",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity9 = new CartoonEntity("Poeye", "India", "male", "appi", "Comdey", "suhas", "appi",
				LocalDate.now(), LocalDate.now());

		CartoonEntity entity10 = new CartoonEntity("Road Runner", "India", "male", "Ranjita", "Comdey", "suhas", "Ranjita",
				LocalDate.now(), LocalDate.now());
		CartoonCharacterDAO dao=new CartoonCharacterDAOImpl();

		List<CartoonEntity> list=new ArrayList<CartoonEntity>();
		list.add(entity1);
		list.add(entity2);
		list.add(entity3);
		list.add(entity4);
		list.add(entity5);
		list.add(entity6);
		list.add(entity7);
		list.add(entity8);
		list.add(entity9);
		list.add(entity10);

		//Boolean	cartoonEntities	=cartoonCharacterDAO.saveAll(list);
		//System.out.println(cartoonEntities);
		//CartoonEntity cartoonEntity	=cartoonCharacterDAO.findByName("Betty Boop");
		//System.out.println(cartoonEntity);
		dao.total();
		dao.findByMaxCreatedDate();
		
		dao.findByMaxCreatedDate();
		dao.findAllNameAndCountryAndAuthor();
		dao.findAuthorByName("Garfield");
		
		












	}
}

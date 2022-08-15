package com.xworkz.freedomfighter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.freedomfighter.dao.FreedomFighterDAO;
import com.xworkz.freedomfighter.dao.FreedomFighterDAOImpl;
import com.xworkz.freedomfighter.entity.FreedomFighterEntity;

public class FreedomFighterWar {

	public static void main(String[] args) {

		FreedomFighterEntity entity1 = new FreedomFighterEntity(1, "Sardar Vallabhbhai Patel",
				LocalDate.of(1875, 10, 31), LocalDate.of(1950, 12, 15), "Male", "Bombay", "suhas", "Ashok",
				LocalDateTime.of(2010, 3, 13, 12, 30), LocalDateTime.of(2015, 05, 24, 10, 20));

		FreedomFighterEntity entity2 = new FreedomFighterEntity(2, "Dr. Rajendra Prasad	", LocalDate.of(1884, 12, 3),
				LocalDate.of(1963, 02, 28), "Male", "Ziradei", "suhas", "Shivu", LocalDateTime.of(2012, 5, 18, 8, 0),
				LocalDateTime.of(2020, 01, 23, 12, 0));

		FreedomFighterEntity entity3 = new FreedomFighterEntity(3, "Rani Laxmi Bai", LocalDate.of(1828, 11, 19),
				LocalDate.of(1858, 6, 18), "Female", "Varanasi", "suhas", "Kumar", LocalDateTime.of(2009, 8, 11, 4, 30),
				LocalDateTime.of(2016, 05, 24, 10, 20));

		FreedomFighterEntity entity4 = new FreedomFighterEntity(4, "Bhagat Singh", LocalDate.of(1907, 9, 28),
				LocalDate.of(1931, 03, 23), "Male", "Banga", "suhas", "Gururaj", LocalDateTime.of(2014, 6, 12, 11, 30),
				LocalDateTime.of(2021, 02, 01, 2, 15));

		FreedomFighterDAO dao = new FreedomFighterDAOImpl();
//		boolean save = dao.save(entity1);
//		System.out.println(save);

		List<FreedomFighterEntity> entities = new ArrayList<FreedomFighterEntity>();
		entities.add(entity2);
		entities.add(entity3);
		entities.add(entity4);

		boolean temp = dao.saveAll(entities);
		System.out.println(temp);

	}

}

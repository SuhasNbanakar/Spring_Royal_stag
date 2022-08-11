package com.xworkz.resort;

import java.time.LocalDate;
import java.time.LocalTime;

import com.xworkz.resort.dao.ResortDAO;
import com.xworkz.resort.dao.ResortDAOImpl;
import com.xworkz.resort.entity.ResortEntity;

public class ResortBoot {

	public static void main(String[] args) {

		ResortEntity resort = new ResortEntity();
		resort.setId(1);
		resort.setName("Hony Resort");
		resort.setLocation("Bannergatha");
		resort.setCheckInTime(LocalTime.of(10, 30));
		resort.setCheckOutTime(LocalTime.of(9, 0));
		resort.setCreateBy("Hanamant");
		resort.setCreateDate(LocalDate.of(2022, 10, 22));
		resort.setUpdateDate(LocalDate.of(2022, 10, 29));
		resort.setOwner("Suhas");
		resort.setPricePerDay(2500d);

		ResortDAO dao = new ResortDAOImpl();
		boolean save = dao.save(resort);
		System.out.println(save);

	}

}

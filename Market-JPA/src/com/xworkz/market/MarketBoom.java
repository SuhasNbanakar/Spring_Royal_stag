package com.xworkz.market;

import java.time.LocalDate;

import com.xworkz.market.dao.MarketDAO;
import com.xworkz.market.dao.MarketDAOImpl;
import com.xworkz.market.entityt.MarketEntity;
import com.xworkz.market.service.MarketService;
import com.xworkz.market.service.MarketServiceImpl;

public class MarketBoom {

	public static void main(String[] args) {

		MarketEntity entity = new MarketEntity("K R Market", "ben", 10000, LocalDate.of(2020, 8, 24), "suhas", "Shivu",
				LocalDate.of(2021, 4, 13), LocalDate.of(2022, 2, 12));
		MarketEntity entity1 = new MarketEntity("Super Market", "BTM bng", 5000, LocalDate.of(2020, 9, 20), "suhas",
				"Laki", LocalDate.of(2021, 5, 10), LocalDate.of(2022, 3, 2));
		MarketEntity entity2 = new MarketEntity("Relaince market", "Shivamogga", 10000, LocalDate.of(2020, 5, 14),
				"suhas", "Shweta", LocalDate.of(2021, 1, 3), LocalDate.of(2022, 6, 22));

		MarketDAO dao = new MarketDAOImpl();

		MarketService service = new MarketServiceImpl(dao);

		service.validateAndSave(entity1);
	}

}

package com.xworkz.market.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.market.entityt.MarketEntity;
import static com.xworkz.market.util.EMFUtil.*;

public class MarketDAOImpl implements MarketDAO {
	private static EntityManagerFactory factory = getFactory();

	@Override
	public boolean save(MarketEntity entity) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction trn = manager.getTransaction();
			trn.begin();
			manager.persist(entity);
			trn.commit();
			manager.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}

		return false;
	}

}

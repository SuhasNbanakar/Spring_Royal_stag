package com.xworkz.resort.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.resort.entity.ResortEntity;

public class ResortDAOImpl implements ResortDAO {

	@Override
	public boolean save(ResortEntity entity) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			manager.persist(entity);
			tran.commit();
			factory.close();
			manager.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}

		return true;
	}

}

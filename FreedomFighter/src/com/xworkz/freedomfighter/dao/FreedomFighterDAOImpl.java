package com.xworkz.freedomfighter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.freedomfighter.entity.FreedomFighterEntity;
import static com.xworkz.freedomfighter.util.EMFUtil.*;

public class FreedomFighterDAOImpl implements FreedomFighterDAO {

	private EntityManagerFactory factory = getFactory();

	@Override
	public boolean save(FreedomFighterEntity entity) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction tr = manager.getTransaction();
			tr.begin();
			manager.persist(entity);
			tr.commit();
			manager.close();
			factory.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean saveAll(List<FreedomFighterEntity> fighterEntities) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction tr = manager.getTransaction();
			tr.begin();
			for (FreedomFighterEntity entitys : fighterEntities) {
				manager.persist(entitys);
			}
			tr.commit();
			manager.close();
			factory.close();

		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return FreedomFighterDAO.super.saveAll(fighterEntities);
	}

}

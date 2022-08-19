package com.xworkz.cartooncharacter.dao;

import static com.xworkz.cartooncharacter.util.EMFUtil.getFactory;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.cartooncharacter.entity.CartoonEntity;

public class CartoonCharacterDAOImpl implements CartoonCharacterDAO {
	EntityManagerFactory factory = getFactory();

	@Override
	public boolean saveAll(List<CartoonEntity> entity) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction tr = manager.getTransaction();
			tr.begin();
			for (CartoonEntity cartoonEntity : entity) {
				manager.persist(cartoonEntity);

			}
			tr.commit();
			manager.close();

		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public CartoonEntity findByName(String name) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findByName");
			query.setParameter("nm", name);
			Object object = query.getSingleResult();
			if (object != null) {
				CartoonEntity characterEntity = (CartoonEntity) object;
				return characterEntity;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			//manager.getTransaction().rollback();
		} finally {
			manager.close();

		}
		return null;

	}

	@Override
	public Integer total() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("total");
			Object object = query.getSingleResult();
			System.out.println(object);

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public CartoonEntity findByMaxCreatedDate() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findByMaxCreatedDate");
			Object object = query.getSingleResult();
			System.out.println(object);

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();

		}
		return null;
	}

	@Override
	public CartoonEntity findByNameAndCountryAndGenderAndAuthor(String name, String country, String gender,
			String author) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findByNameAndCountryAndGenderAndAuthor");
			query.setParameter("ne", name);
			query.setParameter("co", country);
			query.setParameter("ge", gender);
			query.setParameter("ae", author);
			Object object = query.getSingleResult();
			if (object != null) {
				CartoonEntity characterEntity = (CartoonEntity) object;
				return characterEntity;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public String findAuthorByName(String name) {

		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findAuthorByName");
			query.setParameter("nam", name);
			Object object = query.getSingleResult();
			if (object != null) {
				String string = (String) object;
				return string;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public Object[] findNameAndCountryByAuthor(String author) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findNameAndCountryByAuthor");
			query.setParameter("au", author);
			Object object = query.getSingleResult();
			if (object != null) {
				Object[] objects = (Object[]) object;
				return objects;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public LocalDateTime findCreatedDateByAuthor(String author) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findCreatedDateByAuthor");
			query.setParameter("aut", author);
			Object object = query.getSingleResult();
			if (object != null) {
				LocalDateTime dateTime = (LocalDateTime) object;
				return dateTime;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public void updateAuthorByName(String newAuthor, String name) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction tra = manager.getTransaction();
			tra.begin();
			Query query = manager.createNamedQuery("updateAuthorByName");
			query.setParameter("auth", newAuthor);
			query.setParameter("name", name);
			query.executeUpdate();
			Object object = query.getSingleResult();
			System.out.println(object);
			tra.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	@Override
	public void updateTypeByName(String type, String name) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction tran = manager.getTransaction();
			tran.begin();
			Query query = manager.createNamedQuery("updateTypeByName");
			query.setParameter("ty", type);
			query.setParameter("ns", name);
			query.executeUpdate();
			Object object = query.getSingleResult();
			System.out.println(object);
			tran.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	@Override
	public void deleteByName(String name) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction tra = manager.getTransaction();
			tra.begin();
			Query query = manager.createNamedQuery("deleteByName");
			query.setParameter("mn", name);
			query.executeUpdate();
			Object object = query.getSingleResult();
			System.out.println(object);
			tra.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

	}

	@Override
	public List<CartoonEntity> findAll() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findAll");
			List<CartoonEntity> list = query.getResultList();
			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return CartoonCharacterDAO.super.findAll();
	}

	@Override
	public List<CartoonEntity> findAllByAuthor(String author) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findAllByAuthor");
			query.setParameter("at", author);
			List<CartoonEntity> list = query.getResultList();
			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return CartoonCharacterDAO.super.findAllByAuthor(author);
	}

	@Override
	public List<CartoonEntity> findAllByAuthorAndGender(String author, String gender) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findAllByAuthorAndGender");
			query.setParameter("ah", author);
			query.setParameter("gn", gender);
			List<CartoonEntity> list = query.getResultList();
			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return CartoonCharacterDAO.super.findAllByAuthorAndGender(author, gender);
	}

	@Override
	public List<String> findAllName() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findAllName");
			List<String> list = query.getResultList();
			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return CartoonCharacterDAO.super.findAllName();
	}

	@Override
	public List<String> findAllCountry() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findAllCountry");
			List<String> list = query.getResultList();
			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return CartoonCharacterDAO.super.findAllCountry();
	}

	@Override
	public List<Object[]> findAllNameAndCountry() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findAllNameAndCountry");
			List<Object[]> list = query.getResultList();
			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return CartoonCharacterDAO.super.findAllNameAndCountry();
	}

	@Override
	public List<Object[]> findAllNameAndCountryAndAuthor() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findAllNameAndCountryAndAuthor");
			List<Object[]> list = query.getResultList();
			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return CartoonCharacterDAO.super.findAllNameAndCountryAndAuthor();
	}
}

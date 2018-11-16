package com.fdmgroup.DAO;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.Entities.Gem;

public class GemDao {
	
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;
	
	public GemDao(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		this.emf = emf;
	}
	
	public GemDao() {
		
		
	}

	public void add(Gem gem) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(gem);
		et.commit();
		em.close();
	}

	public Gem get(String gemName) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Gem gemFromDb = em.find(Gem.class, gemName);
		em.close();
		
		return gemFromDb;
	}
	
	public void update(String name, String newLink) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Gem gemFromDb = em.find(Gem.class, name);
		et.begin();
		gemFromDb.setPictureLink(newLink);
		et.commit();
		em.close();
	}
	
	public void remove(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Gem gemFromDb = em.find(Gem.class, name);
		et.begin();
		em.remove(gemFromDb);
		et.commit();
		em.close();
	}


}

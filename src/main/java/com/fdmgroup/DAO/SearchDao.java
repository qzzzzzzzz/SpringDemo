package com.fdmgroup.DAO;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.Entities.Search;

public class SearchDao {
	
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;
	
	public SearchDao(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		this.emf = emf;
	}
	
	public SearchDao() {
		
		
	}

	public void add(Search search) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(search);
		et.commit();
		em.close();
	}

	public Search get(int searchId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		Search searchFromDb = em.find(Search.class, searchId);
		em.close();
		
		return searchFromDb;
	}
}

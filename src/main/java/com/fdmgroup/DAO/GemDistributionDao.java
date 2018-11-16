package com.fdmgroup.DAO;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.Entities.GemDistribution;
import com.fdmgroup.Entities.GemDistributionId;

public class GemDistributionDao {
	
	@Resource(name = "emfBean")
	private EntityManagerFactory emf;
	
	public GemDistributionDao(EntityManagerFactory emf) {
		// TODO Auto-generated constructor stub
		this.emf = emf;
	}
	
	public GemDistributionDao() {
		
		
	}

	public void add(GemDistribution gemDistributionDao) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(gemDistributionDao);
		et.commit();
		em.close();
	}

	public GemDistribution get(GemDistributionId gdId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		GemDistribution gemDistributionFromDb = em.find(GemDistribution.class, gdId);
		em.close();
		
		return gemDistributionFromDb;
	}
	
	public void remove(GemDistributionId gdId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		GemDistribution gdFromDb = em.find(GemDistribution.class, gdId);
		et.begin();
		em.remove(gdFromDb);
		et.commit();
		em.close();
	}

}

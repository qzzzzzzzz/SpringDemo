package com.fdmgroup.Test;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.DAO.GemDistributionDao;
import com.fdmgroup.Entities.GemDistribution;
import com.fdmgroup.Entities.GemDistributionId;

public class GemDistributinDaoTest {
	
	@Test
	public void adding_gemDistribution_persists_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		GemDistribution mockGemDistribution = mock(GemDistribution.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		//act
		GemDistributionDao gdDao = new GemDistributionDao(mockEmf);
		gdDao.add(mockGemDistribution);
		
		
		//assert
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockGemDistribution);
		verify(mockEt).commit();
		verify(mockEm).close();
		
	}
	
	@Test
	public void getting_gemDistribution_retrievers_gemDistribution_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		GemDistributionId mockGdId = mock(GemDistributionId.class);
		
		//act
		GemDistributionDao GdDao = new GemDistributionDao(mockEmf);
		GdDao.get(mockGdId);
		
		//assert
		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(GemDistribution.class, mockGdId);
		order.verify(mockEm).close();
		
	}
	
	@Test
	public void removing_gemDistribution_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		GemDistribution mockGemDistribution = mock(GemDistribution.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		GemDistributionId gdId = new GemDistributionId();
		gdId.setGem("Diamond");
		gdId.setCountry("China");
		when(mockEm.find(GemDistribution.class, gdId)).thenReturn(mockGemDistribution);
		
		//act
		GemDistributionDao gdDao = new GemDistributionDao(mockEmf);
		gdDao.remove(gdId);
				
		//assert
		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockGemDistribution);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).find(GemDistribution.class, gdId);
		order.verify(mockEt).begin();
		order.verify(mockEm).remove(mockGemDistribution);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}

}

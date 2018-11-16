package com.fdmgroup.Test;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.DAO.GemDao;
import com.fdmgroup.Entities.Gem;

public class GemDaoTest {
	
	@Test
	public void adding_gem_persists_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Gem mockGem = mock(Gem.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		//act
		GemDao gDao = new GemDao(mockEmf);
		gDao.add(mockGem);
		
		
		//assert
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockGem);
		verify(mockEt).commit();
		verify(mockEm).close();
		
	}
	
	@Test
	public void getting_gem_retrievers_gem_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Gem mockGem = mock(Gem.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		//act
		GemDao gDao = new GemDao(mockEmf);
		gDao.get("Diamond");
		
		//assert
		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(Gem.class, "Diamond");
		order.verify(mockEm).close();
		
	}
	
	@Test
	public void updatting_gem_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Gem mockGem = mock(Gem.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(Gem.class, "Diamond")).thenReturn(mockGem);
		
		//act
		GemDao gDao = new GemDao(mockEmf);
		gDao.update("Diamond", "aaa.com");
		
		//assert
		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockGem);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).find(Gem.class, "Diamond");
		order.verify(mockEt).begin();
		order.verify(mockGem).setPictureLink("aaa.com");
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
		
	}
	
	@Test
	public void removing_gem_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Gem mockGem = mock(Gem.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(Gem.class, "Diamond")).thenReturn(mockGem);
				
		//act
		GemDao gDao = new GemDao(mockEmf);
		gDao.remove("Diamond");
				
		//assert
		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockGem);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).find(Gem.class, "Diamond");
		order.verify(mockEt).begin();
		order.verify(mockEm).remove(mockGem);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}
}

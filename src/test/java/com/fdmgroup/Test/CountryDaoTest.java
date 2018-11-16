package com.fdmgroup.Test;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.DAO.CountryDao;
import com.fdmgroup.Entities.Country;

public class CountryDaoTest {
	
	@Test
	public void adding_country_persists_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Country mockCountry = mock(Country.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		//act
		CountryDao cDao = new CountryDao(mockEmf);
		cDao.add(mockCountry);
		
		
		//assert
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockCountry);
		verify(mockEt).commit();
		verify(mockEm).close();
		
	}
	
	@Test
	public void getting_country_retrievers_country_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Country mockCountry = mock(Country.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		//act
		CountryDao cDao = new CountryDao(mockEmf);
		cDao.get("US");
		
		//assert
		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(Country.class, "US");
		order.verify(mockEm).close();
		
	}
	
	@Test
	public void updatting_country_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Country mockCountry = mock(Country.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(Country.class, "US")).thenReturn(mockCountry);
		
		//act
		CountryDao cDao = new CountryDao(mockEmf);
		cDao.update("US", "bbb.com");
		
		//assert
		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockCountry);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).find(Country.class, "US");
		order.verify(mockEt).begin();
		order.verify(mockCountry).setCountryMap("bbb.com");
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
		
	}
	
	@Test
	public void removing_country_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		Country mockCountry = mock(Country.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(Country.class, "US")).thenReturn(mockCountry);
				
		//act
		CountryDao cDao = new CountryDao(mockEmf);
		cDao.remove("US");
				
		//assert
		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockCountry);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).find(Country.class, "US");
		order.verify(mockEt).begin();
		order.verify(mockEm).remove(mockCountry);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}

}

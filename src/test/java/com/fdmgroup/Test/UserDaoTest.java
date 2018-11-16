package com.fdmgroup.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import static org.mockito.Mockito.*;


import org.junit.Test;
import org.mockito.InOrder;

import com.fdmgroup.DAO.UserDao;
import com.fdmgroup.Entities.User;

public class UserDaoTest {
	
	@Test
	public void adding_user_persists_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		User mockUser = mock(User.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		//act
		UserDao uDao = new UserDao(mockEmf);
		uDao.add(mockUser);
		
		
		//assert
		verify(mockEmf).createEntityManager();
		verify(mockEm).getTransaction();
		verify(mockEt).begin();
		verify(mockEm).persist(mockUser);
		verify(mockEt).commit();
		verify(mockEm).close();
		
	}
	
	@Test
	public void getting_user_retrievers_user_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		User mockUser = mock(User.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		
		//act
		UserDao uDao = new UserDao(mockEmf);
		uDao.get("qz");
		
		//assert
		InOrder order = inOrder(mockEmf, mockEm);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).find(User.class, "qz");
		order.verify(mockEm).close();
		
	}
	
	@Test
	public void updatting_user_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		User mockUser = mock(User.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(User.class, "qz")).thenReturn(mockUser);
		
		//act
		UserDao uDao = new UserDao(mockEmf);
		uDao.update("qz", "pass111", "male", "qz@g.com");
		
		//assert
		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockUser);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).find(User.class, "qz");
		order.verify(mockEt).begin();
		order.verify(mockUser).setPassword("pass111");
		order.verify(mockUser).setGender("male");	
		order.verify(mockUser).setEmail("qz@g.com");	
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
		
	}
	
	@Test
	public void removing_user_and_cleans_up_resources() {
		
		//arrange
		EntityManagerFactory mockEmf = mock(EntityManagerFactory.class);
		EntityManager mockEm = mock(EntityManager.class);
		EntityTransaction mockEt = mock(EntityTransaction.class);
		User mockUser = mock(User.class);
		when(mockEmf.createEntityManager()).thenReturn(mockEm);
		when(mockEm.getTransaction()).thenReturn(mockEt);
		when(mockEm.find(User.class, "qz")).thenReturn(mockUser);
				
		//act
		UserDao uDao = new UserDao(mockEmf);
		uDao.remove("qz");
				
		//assert
		InOrder order = inOrder(mockEmf, mockEm, mockEt, mockUser);
		order.verify(mockEmf).createEntityManager();
		order.verify(mockEm).getTransaction();
		order.verify(mockEm).find(User.class, "qz");
		order.verify(mockEt).begin();
		order.verify(mockEm).remove(mockUser);
		order.verify(mockEt).commit();
		order.verify(mockEm).close();
	}

}

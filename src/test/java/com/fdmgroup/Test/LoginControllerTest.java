package com.fdmgroup.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.fdmgroup.DAO.UserDao;
import com.fdmgroup.Entities.User;
import com.fdmgroup.spring.web.controller.LoginController;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManagerFactory;


public class LoginControllerTest {
	
	@Mock
	private UserDao uDao;
	
	@InjectMocks
	private LoginController lc = new LoginController();
	
	@Before
	public void startInjectingMocks() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void when_requrestForLogin_then_returnLoginJsp(){
		
		//arrange
		Model mockModel = mock(Model.class);
		
		//act
		String nextPage = lc.goToLogin(mockModel);
		
		//assert
		assertEquals("login", nextPage);
		verify(mockModel).addAttribute("blank_login_user", new User());
	}
	
	@Test
	public void when_enterIncorrectUsername_then_returnLoginJspAndShowInvalidUsername() {
		
		//arrange
		Model mockModel = mock(Model.class);
		User mockUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn("none_existing_username");
		when(uDao.get("none_existing_username")).thenReturn(null);
		
		//act
		String nextPage = lc.loginUser(mockUser, mockModel);
		
		//
		verify(uDao).get("none_existing_username");
		verify(mockModel).addAttribute("blank_login_user", mockUser);
		verify(mockModel).addAttribute("fail_msg", "invalid username");
		assertEquals(nextPage, "login");
	}
	
	
}

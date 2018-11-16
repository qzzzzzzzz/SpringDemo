package com.fdmgroup.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.ui.Model;

import com.fdmgroup.Entities.User;
import com.fdmgroup.spring.web.controller.LoginController;

import static org.mockito.Mockito.*;


public class LoginControllerTest {
	
	@Test
	public void when_requrestForLogin_then_returnLoginJsp(){
		
		//arrange
		LoginController lc = new LoginController();
		Model mockModel = mock(Model.class);
		
		//act
		String nextPage = lc.goToLogin(mockModel);
		
		//assert
		assertEquals("login", nextPage);
		verify(mockModel).addAttribute("blank_login_user", new User());
	}
}

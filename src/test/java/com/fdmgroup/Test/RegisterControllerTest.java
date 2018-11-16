package com.fdmgroup.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.springframework.ui.Model;

import com.fdmgroup.Entities.User;
import com.fdmgroup.spring.web.controller.RegisterController;

public class RegisterControllerTest {
	
	@Test
	public void when_requrestForRegister_then_returnRegisterJsp(){
		
		//arrange
		RegisterController rc = new RegisterController();
		Model mockModel = mock(Model.class);
		
		//act
		String nextPage = rc.goToRegister(mockModel);
		
		//assert
		assertEquals("register", nextPage);
		verify(mockModel).addAttribute("blank_register_user", new User());
	}
}

package com.fdmgroup.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.fdmgroup.DAO.UserDao;
import com.fdmgroup.Entities.User;
import com.fdmgroup.spring.web.controller.RegisterController;

public class RegisterControllerTest {
	
	@Mock
	private UserDao uDao;
	
	@InjectMocks
	private RegisterController rc = new RegisterController();
	
	@Before
	public void startInjectingMocks() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void when_requrestForRegister_then_returnRegisterJsp(){
		
		//arrange
		Model mockModel = mock(Model.class);
		
		//act
		String nextPage = rc.goToRegister(mockModel);
		
		//assert
		assertEquals("register", nextPage);
		verify(mockModel).addAttribute("blank_register_user", new User());
	}
	
	@Test
	public void when_usernameAlreadyExists_then_returnRegisterJspAndShowUsernameAlreadyExists() {
		
		//arrange
		Model mockModel = mock(Model.class);
		User mockUser = mock(User.class);
		User expectedUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn("existing_username");
		when(uDao.get("existing_username")).thenReturn(expectedUser);
				
		//act
		String nextPage = rc.registerUser(mockUser, mockModel);
				
		//assert
		assertEquals("register", nextPage);
		verify(mockModel).addAttribute("blank_register_user", mockUser);
		verify(mockModel).addAttribute("fail_msg", "username already exists!");
	}
	
	@Test
	public void when_passwordNotMeetRequiremets_then_returnRegisterJspAndShowWrongMsg() {
		
		//arrange
		Model mockModel = mock(Model.class);
		User mockUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn("non_existing_username");
		when(uDao.get("non_existing_username")).thenReturn(null);
		when(mockUser.getPassword()).thenReturn("aaa");
				
		//act
		String nextPage = rc.registerUser(mockUser, mockModel);
				
		//assert
		assertEquals("register", nextPage);
		verify(mockModel).addAttribute("blank_register_user", mockUser);
		verify(mockModel).addAttribute("fail_msg", "Your password should contain at least ONE uppercase letter, at least ONE number, at least ONE special symbol, at least EIGHT characters");
	}
	
	@Test
	public void when_usernameNotExistAndPasswordMeetRequirement_then_returnLoginJspAndShowSuccessMsg() {
		
		//arrange
		Model mockModel = mock(Model.class);
		User mockUser = mock(User.class);
		when(mockUser.getUsername()).thenReturn("non_existing_username");
		when(uDao.get("non_existing_username")).thenReturn(null);
		when(mockUser.getPassword()).thenReturn("Qz406550629!");
						
		//act
		String nextPage = rc.registerUser(mockUser, mockModel);
						
		//assert
		assertEquals("login", nextPage);
		verify(mockModel).addAttribute("blank_login_user", mockUser);
		verify(mockModel).addAttribute("success_msg", "You have successfully registered, please login");
	}
}

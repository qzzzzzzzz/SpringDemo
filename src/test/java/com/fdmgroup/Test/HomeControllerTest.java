package com.fdmgroup.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.springframework.ui.Model;

import com.fdmgroup.Entities.Search;
import com.fdmgroup.Entities.User;
import com.fdmgroup.spring.web.controller.HomeController;

public class HomeControllerTest {
	
	@Test
	public void when_requrestForHome_then_returnHomeJsp(){
		
		//arrange
		HomeController hc = new HomeController();
		Search mockSearch = mock(Search.class);
		User mockUser = mock(User.class);
		when(mockSearch.getSearchByGem()).thenReturn(1);
		Model mockModel = mock(Model.class);
		when(mockUser.getUsername()).thenReturn("qz");
		
		//act
		String nextPage = hc.goToHome(mockModel, mockUser, "Diamond");
		
		//assert
		assertEquals("home", nextPage);
		verify(mockModel).addAttribute("blank_search", new Search());
		verify(mockModel).addAttribute("active_user", "qz");
		verify(mockModel).addAttribute("lucky_gem", "Diamond");
	}
	
	@Test
	public void when_selectGem_then_returnSearchByGemJsp() {
		
		//arrange
		HomeController hc = new HomeController();
		Search mockSearch = mock(Search.class);
		User mockUser = mock(User.class);
		when(mockSearch.getSearchByGem()).thenReturn(1);
		Model mockModel = mock(Model.class);

		//act
		String nextPage = hc.doSearch(mockModel, mockSearch, mockUser, "Diamond");
		
		//assert
		assertEquals("searchByGem", nextPage);
	}

	@Test
	public void when_selectCountry_then_returnSearchByCountryJsp() {
		
		//arrange
		HomeController hc = new HomeController();
		Search mockSearch = mock(Search.class);
		User mockUser = mock(User.class);
		when(mockSearch.getSearchByGem()).thenReturn(0);
		Model mockModel = mock(Model.class);

		//act
		String nextPage = hc.doSearch(mockModel, mockSearch, mockUser, "Diamond");
		
		//assert
		assertEquals("searchByCountry", nextPage);
	}
	
	@Test
	public void when_selectSelect_then_returnHomeJsp() {
		
		//arrange
		HomeController hc = new HomeController();
		Search mockSearch = mock(Search.class);
		User mockUser = mock(User.class);
		when(mockSearch.getSearchByGem()).thenReturn(2);
		Model mockModel = mock(Model.class);
		when(mockUser.getUsername()).thenReturn("qz");

		//act
		String nextPage = hc.doSearch(mockModel, mockSearch, mockUser, "Diamond");
		
		//assert
		assertEquals("home", nextPage);
		verify(mockModel).addAttribute("active_user", "qz");
		verify(mockModel).addAttribute("lucky_gem", "Diamond");
	}
}

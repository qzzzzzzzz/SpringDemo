package com.fdmgroup.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fdmgroup.spring.web.controller.IndexController;

public class IndexControllerTest {
	
	@Test
	public void when_requrestForIndex_then_returnIndexJsp(){
		
		IndexController ic = new IndexController();
		String nextPage = ic.goToIndex();
		
		assertEquals("index", nextPage);
	}

}

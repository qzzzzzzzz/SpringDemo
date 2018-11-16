package com.fdmgroup.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fdmgroup.spring.web.controller.ForgetController;

public class ForgetControllerTest {

	@Test
	public void when_requrestForForget_then_returnForgetJsp(){
		
		//arrange
		ForgetController rc = new ForgetController();
		
		//act
		String nextPage = rc.goToForget();
		
		//assert
		assertEquals("forget", nextPage);
	}
}

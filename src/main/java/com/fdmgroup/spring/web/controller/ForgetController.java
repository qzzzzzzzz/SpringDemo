package com.fdmgroup.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "forget")
public class ForgetController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String goToForget() {
		// TODO Auto-generated method stub
		return "forget";
	}

}
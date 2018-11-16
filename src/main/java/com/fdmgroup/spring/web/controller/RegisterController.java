package com.fdmgroup.spring.web.controller;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.DAO.UserDao;
import com.fdmgroup.Entities.User;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	
	@Resource(name = "userDaoBean")
	private UserDao uDao;

	@RequestMapping(method = RequestMethod.GET)
	public String goToRegister(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("blank_register_user", new User());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerUser(User user, Model model) {

		//System.out.println(user);
		
		boolean success = true;
			
		String failMsg = "";
		
		User expected = uDao.get(user.getUsername());
		
		if(expected != null) {
			
			success = false;
			failMsg = "username already exists!";
			user.setPassword("");
			model.addAttribute("blank_register_user", user);
			model.addAttribute("fail_msg", failMsg);
			return "register";
		
		}else {
			
			failMsg = "Your password should contain ";
			int wrongTime = 0;
			
			if(user.getPassword().equals(user.getPassword().toLowerCase())) {
				
				success = false;
				if (wrongTime != 0) {
						
					failMsg += ", ";
				}
				failMsg += "at least ONE uppercase letter";
				wrongTime++;
			}
				
			if(user.getPassword().equals(user.getPassword().toUpperCase())) {
					
				success = false;
				if (wrongTime != 0) {
						
					failMsg += ", ";
				}
					
				failMsg += "at least ONE lowercase letter";
				wrongTime++;
			}
				
			if(!user.getPassword().matches(".*\\d.*")) {
	
				success = false;
				if (wrongTime != 0) {
						
					failMsg += ", ";
				}
					
				failMsg += "at least ONE number";
				wrongTime++;
			}
				
			if(user.getPassword().matches("[a-zA-Z0-9 ]*")) {
					
				success = false;
				if (wrongTime != 0) {
						
					failMsg += ", ";
				}
					
				failMsg += "at least ONE special symbol";
				wrongTime++;
			}
				
			if(user.getPassword().length() < 8) {
	
				success = false;
				if (wrongTime != 0) {
						
					failMsg += ", ";
				}
					
				failMsg += "at least EIGHT characters";
			}
		}
		
		if (success) {
			
			uDao.add(user);
			
			user.setPassword("");
			model.addAttribute("blank_login_user", user);
			model.addAttribute("success_msg", "You have successfully registered, please login");
			return "login";	
		
		}else {
			
			failMsg += ".";
			user.setPassword("");
			model.addAttribute("blank_register_user", user);
			model.addAttribute("fail_msg", failMsg);
			return "register";

		}
	}

}

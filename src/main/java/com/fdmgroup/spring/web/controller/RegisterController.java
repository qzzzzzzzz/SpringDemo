package com.fdmgroup.spring.web.controller;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.DAO.UserDao;
import com.fdmgroup.Entities.User;
import static com.fdmgroup.spring.web.model.RegisterModel.*;

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

		
		boolean success = false;			
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
			
			failMsg = generateFailMsg(user.getPassword());
			if (failMsg.equals("Your password should contain ")) {
				
				success = true;
			}
		}
		
		if (success) {
			
			uDao.add(user);
			user.setPassword("");
			model.addAttribute("blank_login_user", user);
			model.addAttribute("success_msg", "You have successfully registered, please login");
			return "login";	
		
		}else {
			
			user.setPassword("");
			model.addAttribute("blank_register_user", user);
			model.addAttribute("fail_msg", failMsg);
			return "register";
		}
	}
}

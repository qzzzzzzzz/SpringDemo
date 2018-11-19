package com.fdmgroup.spring.web.controller;

import static com.fdmgroup.spring.web.service.LoginModel.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.DAO.UserDao;
import com.fdmgroup.Entities.User;;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes(value = { "blank_login_user", "lucky_gem" })
public class LoginController {

	@Resource(name = "userDaoBean")
	private UserDao uDao;

	@RequestMapping(method = RequestMethod.GET)
	public String goToLogin(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("blank_login_user", new User());
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String loginUser(User user, Model model) {

		User expected = uDao.get(user.getUsername());
		model.addAttribute("blank_login_user", user);

		if (expected == null) {

			model.addAttribute("fail_msg", "invalid username");
			return "login";

		} else if (!user.getPassword().equals(expected.getPassword())) {

			model.addAttribute("fail_msg", "invalid password");
			return "login";

		} else {

			String username = user.getUsername();
			model.addAttribute("active_user", username);

			String luckyGem = generateLuckyGem();
			model.addAttribute("lucky_gem", luckyGem);

			return "home";
		}
	}

}

package com.fdmgroup.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.Entities.Search;
import com.fdmgroup.Entities.User;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes(value = {"blank_login_user", "lucky_gem"})
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String goToHome(Model model, @ModelAttribute(value = "blank_login_user") User user, @ModelAttribute(value = "lucky_gem") String luckyGem) {
		model.addAttribute("blank_search", new Search());
		model.addAttribute("active_user", user.getUsername());
		model.addAttribute("lucky_gem", luckyGem);
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doSearch(Model model, Search search, @ModelAttribute(value = "blank_login_user") User user, @ModelAttribute(value = "lucky_gem") String luckyGem) {
		
		if (search.getSearchByGem() == 1) {
			
			return "searchByGem";
			
		}else if (search.getSearchByGem() == 0)  {
			
			return "searchByCountry";
		
		}else {
			
			model.addAttribute("active_user", user.getUsername());
			model.addAttribute("lucky_gem", luckyGem);
			return "home";
		}
	}

}

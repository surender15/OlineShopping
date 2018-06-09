package com.ds.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ds.shoppingbackend.dao.CategoryDAO;

@Controller
public class WelcomeController {

	@Autowired
    private CategoryDAO categoryDAO;
	//private String message = "Hello World";


	@RequestMapping(value= { "/", "/home", "/index"})
	public ModelAndView home() {
		ModelAndView mv= new ModelAndView("welcome");
		
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("title","Home");	
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv= new ModelAndView("welcome");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv= new ModelAndView("welcome");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	

}
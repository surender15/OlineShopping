package com.ds.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	
	private String message = "Hello World";

	/*@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView  welcome() 
	{
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("message","welcome to the Online shopping");
		return mv;
	}*/
	
	
	
	@RequestMapping(value= { "/", "/home", "/index"})
	public ModelAndView home() {
		ModelAndView mv= new ModelAndView("welcome");
		
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
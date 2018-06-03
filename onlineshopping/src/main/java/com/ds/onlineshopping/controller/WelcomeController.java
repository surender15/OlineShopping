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
	
	@RequestMapping("/Test")
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greeting) {
		if(greeting == null)
			greeting="Welcome to the online shopping";
		ModelAndView mv= new ModelAndView("welcome");
		mv.addObject("welcome",greeting);
		return mv;
	}

}
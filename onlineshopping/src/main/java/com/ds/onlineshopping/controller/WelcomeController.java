package com.ds.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	
	private String message = "Hello World";

	@RequestMapping(value= {"/","/home","/index"})
	public String welcome() 
	{
		
		return "welcome";
	}

}
package com.ds.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ds.shoppingbackend.entity.Category;
import com.ds.shoppingbackend.entity.Product;
import com.ds.shoppingbackend.service.CategoryService;
import com.ds.shoppingbackend.service.ProductService;

@Controller
public class WelcomeController {

	
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("welcome");

		mv.addObject("categories", categoryService.findall());
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);

		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping("/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * Methods to load all the products based on category*/
	 
	@RequestMapping("/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("welcome");

		mv.addObject("title", "All Products");
		
		mv.addObject("categories", categoryService.findall());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping("/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("welcome");

		// categoryDAO to fetch a single category
		Category category = null;
		category = categoryService.findId(id);
		mv.addObject("title", category.getName());

		// passign the list of categories available
		// This will be displayed in side-bar
		mv.addObject("categories", categoryService.findall());

		// passing the single category object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}


	/*
	 * Viewing a single product
	 * */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showingSingleProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("welcome");

		Product product = productService.get(id);
		//update the view count 
		product.setViews(product.getViews()+1);
		productService.modify(product);
		
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	}
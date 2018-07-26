package com.ds.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.shoppingbackend.entity.Product;
import com.ds.shoppingbackend.service.ProductService;

@Controller
@RequestMapping("/json/data")
public class DataController {

	@Autowired
	private ProductService productServive;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		return productServive.listActiveProducts();
		//return all the active products list
	}
	
	@RequestMapping("category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable  int id){
		return productServive.listActiveProductsByCategory(id);
	}
	
	@RequestMapping("/all/products/top/{count}")
	@ResponseBody
	public List<Product> getTopProducts(@PathVariable  int count){
		return productServive.getLatestActiveProducts(count);
	}
	
	
	
	
}

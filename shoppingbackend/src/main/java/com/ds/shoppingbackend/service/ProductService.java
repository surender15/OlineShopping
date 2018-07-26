package com.ds.shoppingbackend.service;

import java.util.List;


import com.ds.shoppingbackend.entity.Product;


public interface ProductService {

	Product get(int productId);
	List<Product> list();
	
	boolean add(Product product);
	boolean modify(Product product);
	boolean delete(Product product);
	
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}

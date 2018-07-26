package com.ds.shoppingbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.shoppingbackend.entity.Category;


public interface CategoryService {

	
	public List<Category> findall();

	public boolean add(Category category);

	public Category findId(int id);
	
}

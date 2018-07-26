package com.ds.shoppingbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.shoppingbackend.entity.Category;
import com.ds.shoppingbackend.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	private  CategoryRepository categoryRepository;
	
	private  List<Category> categories = new ArrayList<>();
	
	

	@Override
	public List<Category> findall() {
		return categoryRepository.findAll();
	}
	@Override
	public boolean add(Category category) {
	categoryRepository.save(category);
	return true;	
	}
	@Override
	public Category findId(int id) {
		
		return categoryRepository.findById(id).get();
	}

}

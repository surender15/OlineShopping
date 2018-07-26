package com.ds.shoppingbackend.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ds.shoppingbackend.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	

	List<Product> findByActive(boolean active);
	
	List<Product> findByActiveAndCategoryId(boolean active,int categoryId);

	List<Product> findByActive(boolean active, Pageable pageable);
}

package com.ds.shoppingbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ds.shoppingbackend.entity.Product;
import com.ds.shoppingbackend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product get(int productId) {

		Product product;
		try {
			product = productRepository.findById(productId).get();
			return product;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Product> list() {
		List<Product> list = new ArrayList<>();
		productRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public boolean add(Product product) {
		try {
			productRepository.save(product);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean modify(Product product) {
		try {
			productRepository.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			this.modify(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		List<Product> list = new ArrayList<>();
		productRepository.findByActive(true).forEach(e -> list.add(e));
		return list;
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		List<Product> list = new ArrayList<>();
		productRepository.findByActiveAndCategoryId(true, categoryId).forEach(e -> list.add(e));
		return list;
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {

		List<Product> list = new ArrayList<>();
		Pageable topResult = new PageRequest(0, count);
		productRepository.findByActive(true, topResult).forEach(e->list.add(e));
		return list;
	}

}

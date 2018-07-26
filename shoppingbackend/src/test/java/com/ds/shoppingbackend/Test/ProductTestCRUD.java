package com.ds.shoppingbackend.Test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ds.shoppingbackend.entity.Product;
import com.ds.shoppingbackend.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductTestCRUD {

	@Autowired
	private ProductService productservice;
	
	@Transactional
	@Test
	public void testlistActiveProducts() {
		
	
   // Assert.assertEquals("Something went wrong",3,productservice.listActiveProductsByCategory(3).size());
    Assert.assertEquals("Something went wrong",4,productservice.getLatestActiveProducts(4).size());
	
		
		
	}
}

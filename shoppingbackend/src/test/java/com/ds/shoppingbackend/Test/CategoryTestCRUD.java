package com.ds.shoppingbackend.Test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ds.shoppingbackend.entity.Category;
import com.ds.shoppingbackend.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
public class CategoryTestCRUD {

	@Autowired
	private CategoryService categoryService ;

	

	@Transactional
	
	@Test
	public void testingCRUD_category() {

		Category category = new Category();

	
		category.setId(1);
		category.setName("Television");
		category.setDescription("Description for television");
		category.setImageURL("CAT_1.png");	
		Assert.assertEquals("success",true, categoryService.add(category));
		
		
		category.setId(2);
		category.setName("TV");
		category.setDescription("Description for Tv");
		category.setImageURL("CAT_2.png");	
		
		
		//boolean result= categoryService.add(category);
		Assert.assertEquals("success",true, categoryService.add(category));
		//Assert.assertEquals(2, categoryService.findall().size());
		

		category.setId(3);
		category.setName("Mobile");
		category.setDescription("Description for Mobbile");
		category.setImageURL("CAT_3.png");	
		Assert.assertEquals("success",true, categoryService.add(category));
		
		Assert.assertEquals("success",3, categoryService.findall().size());
		
		
	 /*  boolean expectedString = true;
		boolean actualString =  categoryService.add(category);
		if (expectedString == actualString  )
		{
		System.out.println("success");	
		}*/
	
		  //assertEquals(true,categoryService.add(category));		
}
}

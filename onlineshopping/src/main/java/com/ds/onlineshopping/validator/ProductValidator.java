package com.ds.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ds.shoppingbackend.entity.Product;

public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Product product = (Product)target;
		 if(product.getFile()==null||
				 product.getFile().getOriginalFilename()==" ")
		 {
			 errors.rejectValue("file", null, "Please upload a file!");
			 return;
		 }
		   
		 //validating the format of the file uploaded
		 
		 else if(!(
				 product.getFile().getContentType().equals("image/jpeg")||
				 product.getFile().getContentType().equals("image/png") ||
				 product.getFile().getContentType().equals("image/jpg") 
				 ))
		 {
			 errors.rejectValue("file", null,"Please use only image file for upload!");
		 }
		 return;
	}

}

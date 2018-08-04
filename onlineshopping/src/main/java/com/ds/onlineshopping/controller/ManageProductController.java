package com.ds.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ds.onlineshopping.utility.FileUploadUtility;
import com.ds.onlineshopping.validator.ProductValidator;
import com.ds.shoppingbackend.entity.Category;
import com.ds.shoppingbackend.entity.Product;
import com.ds.shoppingbackend.service.CategoryService;
import com.ds.shoppingbackend.service.ProductService;

@Controller
@RequestMapping("/manage")
public class ManageProductController {
	
@Autowired	
CategoryService categoryService;

@Autowired
ProductService productService;


@RequestMapping(value="/products",method=RequestMethod.GET)
public ModelAndView showManageProducts(@RequestParam(name="operation",required=false) String operation)
{
	ModelAndView mv= new ModelAndView("welcome");
	mv.addObject("Title", "Manage Products");
	mv.addObject("userClickManageProduct", true);
	
	
	Product nProduct= new Product();
	
	//set few fields
	nProduct.setSupplierId(1);
	nProduct.setActive(true);
	mv.addObject("product",nProduct);
	
	if(operation!=null)
	{
		if(operation.equals("product"))
		{
			mv.addObject("message","product submited succesfully");	
		}
	}
	
	
	return mv;
}


/*handling product submission*/
@RequestMapping(value="/products",method=RequestMethod.POST)
public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult results,Model model,
		HttpServletRequest request)
{
	
	
	new ProductValidator().validate(mProduct,results);
	//check if there are any errors
	if(results.hasErrors())
	{
		model.addAttribute("Title", "Manage Products");
		model.addAttribute("userClickManageProduct", true);	
		return "welcome";
	}
	
	//create a new product record
	productService.add(mProduct);

	if(!mProduct.getFile().getOriginalFilename().equals("")) {
		FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		//request -- is for real path
		//mProduct.getFile() -- providing the multipart file 
	}
	return "redirect:/manage/products?operation=product";
			
}

//returning categories for all the request mapping 
@ModelAttribute("categories")
public List<Category> getCategories()
{
	return categoryService.findall();
}
}

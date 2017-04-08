package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.Category;
import com.rest.domain.ProductList;
import com.rest.repository.CategoryRepository;
import com.rest.repository.ProductRepository;

@RestController
public class ProductController {
		
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value="/products/{category}", method=RequestMethod.GET)
	public @ResponseBody ProductList findByCategory(@PathVariable("category") String categoryName) {
		Category category = categoryRepository.findByName(categoryName);
		return new ProductList(productRepository.findByCategory(category));
	}

}

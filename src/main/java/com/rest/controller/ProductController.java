package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.Product;
import com.rest.repository.ProductRepository;

@RestController
public class ProductController {
		
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/test")
	public @ResponseBody Product getProduct() {
		Product product = productRepository.findById(1L);
		return product;
	}

}

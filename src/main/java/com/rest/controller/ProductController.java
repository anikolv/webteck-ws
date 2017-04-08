package com.rest.controller;

import static com.rest.domain.Status.ERROR;
import static com.rest.domain.Status.OK;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.Category;
import com.rest.domain.Product;
import com.rest.domain.XmlDataDTO;
import com.rest.repository.CategoryRepository;
import com.rest.repository.ProductRepository;

@RestController
public class ProductController {
		
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private static String EMPTY_RESULT = "No products found for the given category";
	
	private static String INVALID_CATEGORY = "Invalid category";
	
	@GetMapping(value = "/products/{category}")
	public @ResponseBody XmlDataDTO findByCategory(@PathVariable("category") String categoryName) {
		final Category category = categoryRepository.findByName(categoryName);
		if (category != null) {
			final List<Product> products = productRepository.findByCategoryAndQuantityGreaterThan(category,
					BigInteger.ZERO.intValue());
			if (!products.isEmpty()) {
				return new XmlDataDTO(products, OK);
			} else {
				return new XmlDataDTO(ERROR, EMPTY_RESULT);
			}
		} else {
			return new XmlDataDTO(ERROR, INVALID_CATEGORY);
		}
	}

}

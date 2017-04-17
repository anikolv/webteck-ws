package com.rest.controller;

import static com.rest.domain.Status.ERROR;
import static com.rest.domain.Status.OK;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.Category;
import com.rest.domain.Product;
import com.rest.repository.CategoryRepository;
import com.rest.repository.ProductRepository;

import dto.ProductRequestDTO;
import dto.ProductResponseDTO;

@RestController
public class ProductController {
		
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private static String EMPTY_RESULT = "No products found for the given category";
	
	private static String INVALID_CATEGORY = "Invalid category";
	
	@GetMapping(value = "/products/findByCategory/{category}")
	public @ResponseBody ProductResponseDTO findByCategory(@PathVariable("category") String categoryName) {
		final Category category = categoryRepository.findByName(categoryName);
		if (category != null) {
			final List<Product> products = productRepository.findByCategoryAndQuantityGreaterThan(category,
					BigInteger.ZERO.intValue());
			if (!products.isEmpty()) {
				return new ProductResponseDTO(products, OK);
			} else {
				return new ProductResponseDTO(ERROR, EMPTY_RESULT);
			}
		} else {
			return new ProductResponseDTO(ERROR, INVALID_CATEGORY);
		}
	}
	
	@GetMapping(value = "/admin/product/deleteById/{id}")
	public void removeProduct(@PathVariable("id") Long productId) {
		productRepository.delete(productId);
	}
	
	@GetMapping(value = "/products/getAll")
	public @ResponseBody ProductResponseDTO getAllProducts() {
		return new ProductResponseDTO((List<Product>) productRepository.findAll(), OK);
	}
	
	@PostMapping(value = "/products/add")
	public void addProduct(@RequestBody ProductRequestDTO productDTO) {
		
		Product product = new Product();
		product.setCategory(categoryRepository.findOne(productDTO.getCategoryId()));
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setQuantity(productDTO.getQuantity());
		product.setImage(productDTO.getImage());
		product.setPrice(productDTO.getPrice());
		
		productRepository.save(product);
	}
	
	@GetMapping(value = "/products/findById/{id}")
	public Product findById(@PathVariable("id") Long id) {
		return productRepository.findOne(id);
	}

}

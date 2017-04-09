package com.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Category;
import com.rest.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	  Product findById(Long id);
	  
	  List<Product> findByCategoryAndQuantityGreaterThan(Category category, int qantity);
}
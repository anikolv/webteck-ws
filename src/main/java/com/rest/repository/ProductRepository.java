package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	  Product findById(Long id);
	  
}
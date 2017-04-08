package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	  Category findByName(String name);
	  	  
}
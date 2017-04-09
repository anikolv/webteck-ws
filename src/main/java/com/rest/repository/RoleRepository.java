package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	  Role findByName(String name);
	  	  
}
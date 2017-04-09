package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	  User findById(Long id);

}
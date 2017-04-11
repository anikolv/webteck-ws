package com.rest.controller;

import static com.rest.domain.Status.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.User;
import com.rest.repository.RoleRepository;
import com.rest.repository.UserRepository;

import dto.UserRequestDTO;
import dto.UserResponseDTO;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping(value = "/findAll")
	public UserResponseDTO getAllUsers() {
		return new UserResponseDTO((List<User>) userRepository.findAll(), OK);
	}
	
	@GetMapping(value = "/deleteById/{id}")
	public void removeUser(@PathVariable("id") Long userId) {
		userRepository.delete(userId);
	}
	
	@PostMapping(value = "/add")
	public void addUser(@RequestBody UserRequestDTO userDTO) {
		
		User user = new User();
		user.setRole(roleRepository.findOne(userDTO.getRoleId()));
		user.setActive(userDTO.getActive());
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		
		userRepository.save(user);
	}
}

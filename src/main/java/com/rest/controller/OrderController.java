package com.rest.controller;

import static com.rest.domain.Status.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.Order;
import com.rest.repository.OrderRepository;

import dto.OrderResponseDTO;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping(value = "/findAll")
	public OrderResponseDTO getAllUsers() {
		return new OrderResponseDTO((List<Order>) orderRepository.findAll(), OK);
	}
}

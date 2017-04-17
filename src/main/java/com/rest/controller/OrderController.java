package com.rest.controller;

import static com.rest.domain.Status.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.domain.Order;
import com.rest.domain.OrderProduct;
import com.rest.domain.Product;
import com.rest.repository.OrderProductRepository;
import com.rest.repository.OrderRepository;
import com.rest.repository.ProductRepository;

import dto.OrderResponseDTO;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderProductRepository orderProductRepository;
	
	@GetMapping(value = "/findAll")
	public OrderResponseDTO getAllUsers() {
		return new OrderResponseDTO((List<Order>) orderRepository.findAll(), OK);
	}
	
	@GetMapping(value = "/findById/{id}")
	public Order findById(@PathVariable("id") Long id) {
		return orderRepository.findOne(id);
	}
	
	@GetMapping(value = "/create")
	public Long createOrder() {

		Order order = new Order();
		order.setStatus("NEW");
		
		orderRepository.save(order);
		
		return order.getId();
		
	}
	
	@GetMapping(value = "/{orderId}/addProduct/{productId}")
	public void addProduct(@PathVariable("orderId") Long orderId, @PathVariable("productId") Long productId) {
		
		Product product = productRepository.findOne(productId);
		Order order = orderRepository.findOne(orderId);
		order.setCost(product.getPrice());
		
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setProduct(product);
		orderProduct.setAmount(product.getPrice());
		orderProduct.setQantity(1);
		orderProduct.setOrder(order);
		
		orderProductRepository.save(orderProduct);
	}
	
	@GetMapping(value = "/{orderId}/removeProduct/{productId}")
	public void removeProduct(@PathVariable("orderId") Long orderId, @PathVariable("productId") Long productId) {
		
		Product product = productRepository.findOne(productId);
		Order order = orderRepository.findOne(orderId);

		OrderProduct orderProduct = orderProductRepository.findByOrderAndProduct(order, product);
		orderProductRepository.delete(orderProduct);
	}
}

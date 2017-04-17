package com.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.domain.Order;
import com.rest.domain.OrderProduct;
import com.rest.domain.Product;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Long> {
	
	OrderProduct findByOrderAndProduct(Order order, Product product);
}
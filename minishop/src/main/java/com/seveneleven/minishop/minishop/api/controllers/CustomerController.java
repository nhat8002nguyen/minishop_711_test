package com.seveneleven.minishop.minishop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;
import com.seveneleven.minishop.minishop.domain.services.CustomerService;

@RestController
@RequestMapping(path = "/api/customer-service", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class CustomerController {
	private final CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	public ResponseEntity<?> placeOrder(Order order) {
		String orderId = service.placeOrder(order);
		if (orderId == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(orderId);
	}
}

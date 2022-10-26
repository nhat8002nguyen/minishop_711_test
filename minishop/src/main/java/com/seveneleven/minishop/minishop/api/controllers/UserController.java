package com.seveneleven.minishop.minishop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.minishop.minishop.api.models.request.order.OrderGetRequestDto;
import com.seveneleven.minishop.minishop.api.models.request.order.OrderPostRequestDto;
import com.seveneleven.minishop.minishop.api.models.request.order.OrderRequest;
import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.services.order.OrderService;
import com.seveneleven.minishop.minishop.domain.services.product.ProductService;
import com.seveneleven.minishop.minishop.domain.services.user.UserService;

@RestController
@RequestMapping(path = "/api/v1/customer-service", produces = "application/json")
@CrossOrigin
public class UserController {
	private final UserService userService;
	private final ProductService productService;
	private final OrderService orderService;

	@Autowired
	public UserController(
			UserService service,
			ProductService productService,
			OrderService orderService) {
		this.userService = service;
		this.productService = productService;
		this.orderService = orderService;
	}

	@GetMapping(path = "/orders")
	public ResponseEntity<?> getOrders(@RequestBody OrderGetRequestDto request) {
		// List<Order> orders = orderService.getOrdersOfUser(request.getUsername());
		// if (orders == null) {
		// return ResponseEntity.badRequest().body(Map.of("message", "Cannot get order
		// list"));
		// }
		// return ResponseEntity.ok(Map.of("orders", orders));
		List<Order> orders = orderService.getOrdersOfUser(request.getUsername());
		return ResponseEntity.ok(orders);
	}

	@PostMapping(path = "/orders")
	public ResponseEntity<?> placeOrder(@RequestBody OrderPostRequestDto request,
			@RequestBody OrderRequest orderRequest) {
				return orderService.placeOrder(request.getUsername(), orderRequest)
	}
}

package com.seveneleven.minishop.minishop.api.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.minishop.minishop.domain.exceptions.ExistOrderItemIncludesProductException;
import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.domain.services.order.OrderService;
import com.seveneleven.minishop.minishop.domain.services.product.ProductService;

@RestController
@RequestMapping(path = "/api/admin-service", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class AdminController {
	private final ProductService productService;
	private final OrderService orderService;

	@Autowired
	public AdminController(
			ProductService productService,
			OrderService orderService) {
		this.productService = productService;
		this.orderService = orderService;
	}

	@PostMapping(path = "/product")
	ResponseEntity<?> addProduct(@RequestBody Product product) {
		long id = productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping(value = "/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
		Product result = productService.updateProduct(id, product);
		if (result == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(result);
	}

	@DeleteMapping(path = "/product/{id}")
	ResponseEntity<?> removeProduct(@PathVariable String id) {
		try {
			productService.removeProduct(id);
			return ResponseEntity.noContent().build();
		} catch (ExistOrderItemIncludesProductException e) {
			return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
		}
	}

	@GetMapping(value = "/orders")
	ResponseEntity<?> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		if (orders == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(Map.of("orders", orders));
	}
}

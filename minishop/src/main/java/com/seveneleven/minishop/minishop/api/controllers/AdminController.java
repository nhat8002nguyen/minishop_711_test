package com.seveneleven.minishop.minishop.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;
import com.seveneleven.minishop.minishop.domain.services.AdminService;

@RestController
@RequestMapping(path = "/api/admin-service", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class AdminController {
	private final AdminService service;

	@Autowired
	public AdminController(AdminService service) {
		this.service = service;
	}

	@PostMapping(path = "/product")
	ResponseEntity<?> addProduct(@RequestBody Product product) {
		String id = service.addProduct(product);
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping(value = "/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
		Product result = service.updateProduct(id, product);
		if (result == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(result);
	}

	@DeleteMapping(path = "/product/{id}")
	ResponseEntity<?> removeProduct(@PathVariable String id) {
		service.removeProduct(id);
		return ResponseEntity.noContent().build();
	}
}

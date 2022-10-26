package com.seveneleven.minishop.minishop.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.domain.services.product.ProductService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(path = "/products")
	ResponseEntity<List<Product>> allProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping(path = "/products/{id}")
	ResponseEntity<Product> product(@PathVariable String id) {
		return ResponseEntity.ok(productService.getProductDetail(id));
	}
}

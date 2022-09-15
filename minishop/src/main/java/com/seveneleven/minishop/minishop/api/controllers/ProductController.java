package com.seveneleven.minishop.minishop.api.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;
import com.seveneleven.minishop.minishop.domain.services.ProductService;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {
	private final ProductService productService;
	private Log LOGGER = LogFactory.getLog(ProductController.class);

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(path = "/product")
	ResponseEntity<List<Product>> allProducts() {
		try {
			List<Product> productList = productService.getAllProducts();
			return ResponseEntity.ok(productList);
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping(path = "/product")
	ResponseEntity<?> addProduct(@RequestBody Product product) {
		String id = productService.addProduct(product);
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}

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
		productService.removeProduct(id);
		return ResponseEntity.noContent().build();
	}
}

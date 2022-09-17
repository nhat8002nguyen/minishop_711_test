package com.seveneleven.minishop.minishop.api.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.services.product.ProductService;

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

	@GetMapping(path = "/product/{id}")
	ResponseEntity<Product> product(@PathVariable String id) {
		Product product = productService.getProductDetail(id);
		if (product == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(product);
	}

}

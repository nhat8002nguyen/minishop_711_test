package com.seveneleven.minishop.minishop.domain.exceptions.product_exceptions;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(long id) {
		super("Product " + id + " not found !");
	}

	public ProductNotFoundException(String id) {
		super("Product " + id + " not found !");
	}
}

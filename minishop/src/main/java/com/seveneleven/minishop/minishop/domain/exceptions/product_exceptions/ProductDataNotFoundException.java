package com.seveneleven.minishop.minishop.domain.exceptions.product_exceptions;

public class ProductDataNotFoundException extends RuntimeException {
	public ProductDataNotFoundException() {
		super("Data not found !");
	}
}

package com.seveneleven.minishop.minishop.domain.exceptions.order_exceptions;

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException(long id) {
		super("Order " + id + " not found !");
	}
}

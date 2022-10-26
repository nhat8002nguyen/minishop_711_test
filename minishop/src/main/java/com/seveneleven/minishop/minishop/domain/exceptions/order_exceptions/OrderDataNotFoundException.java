package com.seveneleven.minishop.minishop.domain.exceptions.order_exceptions;

public class OrderDataNotFoundException extends RuntimeException {
	public OrderDataNotFoundException() {
		super("Data not found !");
	}

}

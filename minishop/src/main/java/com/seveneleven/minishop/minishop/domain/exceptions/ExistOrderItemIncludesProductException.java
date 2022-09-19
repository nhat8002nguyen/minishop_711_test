package com.seveneleven.minishop.minishop.domain.exceptions;

public class ExistOrderItemIncludesProductException extends Exception {
	public ExistOrderItemIncludesProductException() {
		super("Product cannot be removed, because an existing order item includes it.");
	}
}

package com.seveneleven.minishop.minishop.domain.exceptions.user_exceptions;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(long id) {
		super("User " + id + " not found !");
	};

	public UserNotFoundException(String name) {
		super("User " + name + " not found !");
	};
}

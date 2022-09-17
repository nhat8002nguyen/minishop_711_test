package com.seveneleven.minishop.minishop.domain.order;

import java.util.Date;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class Customer {
	private final String id;

	private final String username;

	private final String email;

	private final String password;

	private final Date registerDate;
}

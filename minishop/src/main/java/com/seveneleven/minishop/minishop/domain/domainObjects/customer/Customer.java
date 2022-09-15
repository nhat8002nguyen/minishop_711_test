package com.seveneleven.minishop.minishop.domain.domainObjects.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;

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

	private final List<Order> orders = new ArrayList<>();
}

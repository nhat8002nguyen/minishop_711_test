package com.seveneleven.minishop.minishop.repositories;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Customer;
import com.seveneleven.minishop.minishop.domain.order.Order;

public interface CustomerRepository {
	Customer findCustomerByName(String name);

	List<Order> getOrdersByUsername(String name);

	String createOrder(String username, Order order);
}

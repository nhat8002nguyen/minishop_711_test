package com.seveneleven.minishop.minishop.repositories;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.User;

public interface UserRepository {
	User findUserByName(String name);

	List<Order> getOrdersByUsername(String name);

	Long createOrder(String username, Order order);
}

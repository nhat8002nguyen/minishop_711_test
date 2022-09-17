package com.seveneleven.minishop.minishop.repositories;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Order;

public interface OrderRepository {
	List<Order> getAllOrders();

	String createOrder(Order order);

	void removeOrder(String id);

	Order updateOrder(String id, Order order);
}

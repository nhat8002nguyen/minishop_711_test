package com.seveneleven.minishop.minishop.domain.services;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;

public interface OrderService {
	List<Order> getAllOrders();

	String createOrder(Order order);

	void removeOrder(String id);

	Order updateOrder(Order order);
}
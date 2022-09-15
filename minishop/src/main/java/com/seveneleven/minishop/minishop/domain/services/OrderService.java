package com.seveneleven.minishop.minishop.domain.services;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;

public interface OrderService {
	List<Order> getAllOrders();

	void placeOrder(Order order);

	void removeOrder(long id);
}

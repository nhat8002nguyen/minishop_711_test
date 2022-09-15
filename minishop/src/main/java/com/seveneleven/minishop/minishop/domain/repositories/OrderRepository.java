package com.seveneleven.minishop.minishop.domain.repositories;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;

public interface OrderRepository {
	List<Order> getAllOrders();

	List<Order> getOrdersByCustomer(String userId);

	String createOrder(Order order);

	void removeOrder(String id);

	Order updateOrder(String id, Order order);
}

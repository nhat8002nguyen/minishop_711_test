package com.seveneleven.minishop.minishop.domain.services.order;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Order;

public interface OrderService {

	List<Order> getAllOrders();

	Order placeOrder(String username, Order order);

	void removeOrder(String orderId);

	Order updateOrder(String orderId, Order order);

	List<Order> getOrdersOfUser(String name);
}

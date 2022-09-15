package com.seveneleven.minishop.minishop.domain.services;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;

public interface CustomerService {
	String placeOrder(Order order);

	void removeOrder(String orderId);

	Order updateOrder(Order order);
}

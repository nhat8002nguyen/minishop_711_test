package com.seveneleven.minishop.minishop.services.customer;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Customer;
import com.seveneleven.minishop.minishop.domain.order.Order;

public interface CustomerService {
	String placeOrder(String username, Order order);

	void removeOrder(String orderId);

	Order updateOrder(String orderId, Order order);

	List<Order> getOrders(String name);

	Customer getCustomerByName(String name);
}

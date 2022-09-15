package com.seveneleven.minishop.minishop.domain.domainObjects.customer;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;
import com.seveneleven.minishop.minishop.domain.services.CustomerService;
import com.seveneleven.minishop.minishop.domain.services.OrderService;

public class DomainCustomerService implements CustomerService {
	private final OrderService orderService;

	public DomainCustomerService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public String placeOrder(Order order) {
		return orderService.createOrder(order);
	}

	@Override
	public void removeOrder(String orderId) {
		orderService.removeOrder(orderId);
	}

	@Override
	public Order updateOrder(Order order) {
		return orderService.updateOrder(order);
	}

}

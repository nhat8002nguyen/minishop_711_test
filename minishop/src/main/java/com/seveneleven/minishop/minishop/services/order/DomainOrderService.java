package com.seveneleven.minishop.minishop.services.order;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.repositories.CustomerRepository;
import com.seveneleven.minishop.minishop.repositories.OrderRepository;

public class DomainOrderService implements OrderService {
	private final OrderRepository orderRepository;
	private final CustomerRepository customerRepository;

	public DomainOrderService(
			OrderRepository orderRepository,
			CustomerRepository customerRepository) {
		this.orderRepository = orderRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public String placeOrder(String username, Order order) {
		return customerRepository.createOrder(username, order);
	}

	@Override
	public void removeOrder(String orderId) {
		orderRepository.removeOrder(orderId);
	}

	@Override
	public Order updateOrder(String orderId, Order order) {
		return orderRepository.updateOrder(orderId, order);
	}

	@Override
	public List<Order> getOrdersOfCustomer(String username) {
		return customerRepository.getOrdersByUsername(username);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.getAllOrders();
	}
}

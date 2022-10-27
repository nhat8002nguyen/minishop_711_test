package com.seveneleven.minishop.minishop.domain.services.order;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.exceptions.order_exceptions.OrderDataNotFoundException;
import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.repositories.UserRepository;

public class DomainOrderService implements OrderService {
	private final OrderRepository orderRepository;
	private final UserRepository userRepository;

	public DomainOrderService(
			OrderRepository orderRepository,
			UserRepository userRepository) {
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Order placeOrder(String username, Order order) {
		userRepository.findUserByName(username);

		Order createdOrder = orderRepository.createOrder(order);

		return createdOrder;
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
	public List<Order> getOrdersOfUser(String username) {
		List<Order> orders = userRepository.getOrdersByUsername(username);

		if (orders == null || orders.isEmpty()) {
			throw new OrderDataNotFoundException();
		}

		return orders;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.getAllOrders();
	}
}

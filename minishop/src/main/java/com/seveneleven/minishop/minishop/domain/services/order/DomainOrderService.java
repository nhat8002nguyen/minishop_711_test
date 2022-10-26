package com.seveneleven.minishop.minishop.domain.services.order;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.OrderItem;
import com.seveneleven.minishop.minishop.repositories.OrderItemRepository;
import com.seveneleven.minishop.minishop.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.repositories.UserRepository;

public class DomainOrderService implements OrderService {
	private final OrderRepository orderRepository;
	private final UserRepository userRepository;
	private final OrderItemRepository orderItemRepository;

	public DomainOrderService(
			OrderRepository orderRepository,
			UserRepository userRepository,
			OrderItemRepository orderItemRepository) {
		this.orderRepository = orderRepository;
		this.userRepository = userRepository;
		this.orderItemRepository = orderItemRepository;
	}

	@Override
	public Order placeOrder(String username, Order order) {
		userRepository.findUserByName(username);

		saveOrderItems(order.getOrderItems(), order);
		Order createdOrder = orderRepository.createOrder(order);

		return createdOrder;
	}

	private void saveOrderItems(List<OrderItem> orderItems, Order order) {
		orderItems.forEach(item -> orderItemRepository.save(order, item));
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
		return userRepository.getOrdersByUsername(username);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.getAllOrders();
	}
}

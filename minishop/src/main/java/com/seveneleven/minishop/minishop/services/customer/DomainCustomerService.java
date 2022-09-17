package com.seveneleven.minishop.minishop.services.customer;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Customer;
import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.repositories.CustomerRepository;
import com.seveneleven.minishop.minishop.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;

public class DomainCustomerService implements CustomerService {
	private final OrderRepository orderRepository;
	private final CustomerRepository customerRepository;

	public DomainCustomerService(
			OrderRepository orderRepository,
			ProductRepository productRepository,
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
	public Customer getCustomerByName(String name) {
		return customerRepository.findCustomerByName(name);
	}

	@Override
	public List<Order> getOrders(String username) {
		return customerRepository.getOrdersByUsername(username);
	}

}

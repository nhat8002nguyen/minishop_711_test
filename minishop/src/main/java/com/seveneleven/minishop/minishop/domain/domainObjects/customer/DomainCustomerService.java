package com.seveneleven.minishop.minishop.domain.domainObjects.customer;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;
import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;
import com.seveneleven.minishop.minishop.domain.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.domain.repositories.ProductRepository;
import com.seveneleven.minishop.minishop.domain.services.CustomerService;

public class DomainCustomerService implements CustomerService {
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;

	public DomainCustomerService(
			OrderRepository orderRepository,
			ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}

	@Override
	public String placeOrder(Order order) {
		return orderRepository.createOrder(order);
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
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product getProductDetail(String id) {
		return productRepository.getProductDetail(id);
	}
}

package com.seveneleven.minishop.minishop.domain.domainObjects.admin;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;
import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;
import com.seveneleven.minishop.minishop.domain.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.domain.repositories.ProductRepository;
import com.seveneleven.minishop.minishop.domain.services.AdminService;

public class DomainAdminService implements AdminService {
	private final ProductRepository productRepo;
	private final OrderRepository orderRepo;

	public DomainAdminService(
			ProductRepository productRepository,
			OrderRepository orderRepository) {
		this.productRepo = productRepository;
		this.orderRepo = orderRepository;
	}

	@Override
	public String addProduct(Product product) {
		String id = productRepo.addProduct(product);
		return id;
	}

	@Override
	public void removeProduct(String id) {
		productRepo.removeProduct(id);
	}

	@Override
	public Product updateProduct(String id, Product product) {
		Product updatedProduct = productRepo.updateProduct(id, product);
		return updatedProduct;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.getAllOrders();
	}
}

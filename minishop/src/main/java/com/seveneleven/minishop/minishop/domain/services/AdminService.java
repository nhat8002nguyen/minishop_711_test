package com.seveneleven.minishop.minishop.domain.services;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;
import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;

public interface AdminService {
	String addProduct(Product product);

	void removeProduct(String id);

	Product updateProduct(String id, Product product);

	List<Order> getAllOrders();
}

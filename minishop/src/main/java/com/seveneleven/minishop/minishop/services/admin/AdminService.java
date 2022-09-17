package com.seveneleven.minishop.minishop.services.admin;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.Product;

public interface AdminService {
	String addProduct(Product product);

	void removeProduct(String id);

	Product updateProduct(String id, Product product);

	List<Order> getAllOrders();
}

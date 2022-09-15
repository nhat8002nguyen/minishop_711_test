package com.seveneleven.minishop.minishop.domain.services;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;
import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;

public interface CustomerService {
	String placeOrder(Order order);

	void removeOrder(String orderId);

	Order updateOrder(String orderId, Order order);

	List<Product> getAllProducts();

	Product getProductDetail(String id);
}

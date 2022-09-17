package com.seveneleven.minishop.minishop.repositories;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Product;

public interface ProductRepository {
	String addProduct(Product product);

	void removeProduct(String id);

	Product updateProduct(String id, Product product);

	List<Product> getAllProducts();

	Product getProductDetail(String id);
}
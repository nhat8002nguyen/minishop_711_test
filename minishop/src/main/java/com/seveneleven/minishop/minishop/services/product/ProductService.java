package com.seveneleven.minishop.minishop.services.product;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Product;

public interface ProductService {
	String addProduct(Product product);

	void removeProduct(String id);

	Product updateProduct(String id, Product product);

	List<Product> getAllProducts();

	Product getProductDetail(String id);
}

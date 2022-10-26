package com.seveneleven.minishop.minishop.repositories;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.exceptions.ExistOrderItemIncludesProductException;
import com.seveneleven.minishop.minishop.domain.order.Product;

public interface ProductRepository {
	Product findProductById(String id);

	Long addProduct(Product product);

	void removeProduct(String id) throws ExistOrderItemIncludesProductException;

	Product updateProduct(String id, Product product);

	List<Product> getAllProducts();

	Product getProductDetail(String id);
}
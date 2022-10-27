package com.seveneleven.minishop.minishop.domain.services.product;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.exceptions.ExistOrderItemIncludesProductException;
import com.seveneleven.minishop.minishop.domain.order.Product;

public interface ProductService {
	long addProduct(Product product);

	void removeProduct(long id) throws ExistOrderItemIncludesProductException;

	Product updateProduct(long id, Product product);

	List<Product> getAllProducts();

	Product getProductDetail(long id);
}

package com.seveneleven.minishop.minishop.domain.services.product;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.exceptions.ExistOrderItemIncludesProductException;
import com.seveneleven.minishop.minishop.domain.exceptions.product_exceptions.ProductDataNotFoundException;
import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;

public class DomainProductService implements ProductService {
	private final ProductRepository productRepo;

	public DomainProductService(ProductRepository productRepository) {
		this.productRepo = productRepository;
	}

	@Override
	public long addProduct(Product product) {
		return productRepo.addProduct(product);
	}

	@Override
	public void removeProduct(String id) throws ExistOrderItemIncludesProductException {
		productRepo.removeProduct(id);
	}

	@Override
	public Product updateProduct(String id, Product product) {
		return productRepo.updateProduct(id, product);
	}

	@Override
	public List<Product> getAllProducts() throws RuntimeException {
		List<Product> products = productRepo.getAllProducts();
		if (products.isEmpty()) {
			throw new ProductDataNotFoundException();
		}
		return products;
	}

	@Override
	public Product getProductDetail(String id) {
		return productRepo.getProductDetail(id);
	}
}

package com.seveneleven.minishop.minishop.domain.domainObjects.product;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.repositories.ProductRepository;
import com.seveneleven.minishop.minishop.domain.services.ProductService;

public class DomainProductService implements ProductService {
	private final ProductRepository productRepo;

	public DomainProductService(ProductRepository productRepository) {
		this.productRepo = productRepository;
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
		productRepo.updateProduct(id, product);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.getAllProducts();
	}

}

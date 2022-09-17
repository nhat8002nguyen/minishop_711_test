package com.seveneleven.minishop.minishop.services.product;

import java.util.List;

import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;

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
		Product updatedProduct = productRepo.updateProduct(id, product);
		return updatedProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.getAllProducts();
	}

	@Override
	public Product getProductDetail(String id) {
		return productRepo.getProductDetail(id);
	}

}
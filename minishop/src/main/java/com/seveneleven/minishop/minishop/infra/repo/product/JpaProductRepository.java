package com.seveneleven.minishop.minishop.infra.repo.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.seveneleven.minishop.minishop.domain.exceptions.ExistOrderItemIncludesProductException;
import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.infra.dto.ProductDto;
import com.seveneleven.minishop.minishop.infra.mappers.ProductMapper;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;

@Component
public class JpaProductRepository implements ProductRepository {
	private final JpaDBProductRepository jpaDBProductRepo;
	private final ProductMapper mapper = ProductMapper.INSTANCE;

	@Autowired
	public JpaProductRepository(JpaDBProductRepository jpaDBProductRepository) {
		this.jpaDBProductRepo = jpaDBProductRepository;
	}

	@Override
	public String addProduct(Product product) {
		ProductDto productDto = mapper.productToProductDto(product);
		jpaDBProductRepo.save(productDto);
		return productDto.getId();
	}

	@Override
	public void removeProduct(String id) throws ExistOrderItemIncludesProductException {
		try {
			jpaDBProductRepo.deleteById(id);
		} catch (DataIntegrityViolationException exception) {
			throw new ExistOrderItemIncludesProductException();
		}
	}

	@Override
	public Product updateProduct(String id, Product product) {
		Optional<ProductDto> optional = jpaDBProductRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		ProductDto oldProductDto = optional.get();

		ProductDto updatedProduct = mapper.updateProductDtoCompletely(
				oldProductDto.getId(),
				oldProductDto.getCreatedAt(),
				product);

		updatedProduct = jpaDBProductRepo.save(updatedProduct);

		Product newProduct = mapper.productDtoToProduct(updatedProduct);

		return newProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<>();
		Iterable<ProductDto> iterable = jpaDBProductRepo.findAll();

		iterable.forEach(productDto -> productList.add(mapper.productDtoToProduct(productDto)));
		return productList;
	}

	@Override
	public Product getProductDetail(String id) {
		Optional<ProductDto> optional = jpaDBProductRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Product product = mapper.productDtoToProduct(optional.get());
		return product;
	}

	@Override
	public Product findProductById(String id) {
		Optional<ProductDto> optional = jpaDBProductRepo.findById(id);
		return optional.isEmpty() ? null : mapper.productDtoToProduct(optional.get());
	}
}

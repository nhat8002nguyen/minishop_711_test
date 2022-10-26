package com.seveneleven.minishop.minishop.infra.repo.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.seveneleven.minishop.minishop.domain.exceptions.ExistOrderItemIncludesProductException;
import com.seveneleven.minishop.minishop.domain.exceptions.product_exceptions.ProductNotFoundException;
import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.infra.entities.ProductEntity;
import com.seveneleven.minishop.minishop.infra.mappers.OrderMapper;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;

@Component
public class JpaProductRepository implements ProductRepository {
	private final JpaDBProductRepository jpaDBProductRepo;
	private final OrderMapper mapper = OrderMapper.INSTANCE;

	@Autowired
	public JpaProductRepository(JpaDBProductRepository jpaDBProductRepository) {
		this.jpaDBProductRepo = jpaDBProductRepository;
	}

	@Override
	public Long addProduct(Product product) {
		ProductEntity productDto = mapper.productEntityToPojo(product);
		jpaDBProductRepo.save(productDto);
		return productDto.getId();
	}

	@Override
	public void removeProduct(String id) throws ExistOrderItemIncludesProductException {
		try {
			findProductEntityById(id);
			jpaDBProductRepo.deleteById(id);
		} catch (DataIntegrityViolationException exception) {
			throw new ExistOrderItemIncludesProductException();
		}
	}

	private ProductEntity findProductEntityById(String id) {
		Optional<ProductEntity> optional = jpaDBProductRepo.findById(id);
		if (optional.isEmpty()) {
			throw new ProductNotFoundException(id);
		}
		return optional.get();
	}

	@Override
	public Product updateProduct(String id, Product product) {
		ProductEntity oldProductEntity = findProductEntityById(id);

		ProductEntity updatedProduct = mapper.updateProductEntityCompletely(
				oldProductEntity.getId(),
				oldProductEntity.getCreatedAt(),
				product);

		updatedProduct = jpaDBProductRepo.save(updatedProduct);

		Product newProduct = mapper.productEntityToPojo(updatedProduct);

		return newProduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<>();
		Iterable<ProductEntity> iterable = jpaDBProductRepo.findAll();

		iterable.forEach(productDto -> productList.add(mapper.productEntityToPojo(productDto)));
		return productList;
	}

	@Override
	public Product getProductDetail(String id) {
		ProductEntity entity = findProductEntityById(id);
		Product product = mapper.productEntityToPojo(entity);
		return product;
	}

	@Override
	public Product findProductById(String id) {
		return mapper.productEntityToPojo(findProductEntityById(id));
	}
}

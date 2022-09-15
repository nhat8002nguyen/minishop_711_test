package com.seveneleven.minishop.minishop.infra.dto.mappers;

import java.util.Date;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;
import com.seveneleven.minishop.minishop.infra.dto.ProductDto;

@Mapper(imports = UUID.class)
public interface ProductMapper {
	public ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Mapping(target = "id", expression = "java( UUID.randomUUID().toString() )")
	ProductDto productToProductDto(Product product);

	@Mapping(source = "firstCreatedAt", target = "createdAt")
	@Mapping(source = "sourceId", target = "id")
	ProductDto updateProductDtoCompletely(String sourceId, Date firstCreatedAt, Product product);

	Product productDtoToProduct(ProductDto productDto);
}

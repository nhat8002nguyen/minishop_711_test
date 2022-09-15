package com.seveneleven.minishop.minishop.infra.repo.product;

import org.springframework.data.repository.CrudRepository;

import com.seveneleven.minishop.minishop.infra.dto.ProductDto;

public interface JpaDBProductRepository extends CrudRepository<ProductDto, String> {
}
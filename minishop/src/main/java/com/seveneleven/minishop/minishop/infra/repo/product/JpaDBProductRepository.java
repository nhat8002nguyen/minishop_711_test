package com.seveneleven.minishop.minishop.infra.repo.product;

import org.springframework.data.repository.CrudRepository;

import com.seveneleven.minishop.minishop.infra.entities.ProductEntity;

public interface JpaDBProductRepository extends CrudRepository<ProductEntity, String> {
}
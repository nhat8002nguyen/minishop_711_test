package com.seveneleven.minishop.minishop.infra.repo.order;

import org.springframework.data.repository.CrudRepository;

import com.seveneleven.minishop.minishop.infra.entities.OrderEntity;

public interface JpaDBOrderRepository extends CrudRepository<OrderEntity, String> {
}
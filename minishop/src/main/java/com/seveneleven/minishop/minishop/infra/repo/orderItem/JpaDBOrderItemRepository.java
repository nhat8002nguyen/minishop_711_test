package com.seveneleven.minishop.minishop.infra.repo.orderItem;

import org.springframework.data.repository.CrudRepository;

import com.seveneleven.minishop.minishop.infra.entities.OrderItemEntity;

public interface JpaDBOrderItemRepository extends CrudRepository<OrderItemEntity, String> {
}
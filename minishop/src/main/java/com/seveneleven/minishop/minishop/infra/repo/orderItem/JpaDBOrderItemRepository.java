package com.seveneleven.minishop.minishop.infra.repo.orderItem;

import org.springframework.data.repository.CrudRepository;

import com.seveneleven.minishop.minishop.infra.dto.OrderItemDto;

public interface JpaDBOrderItemRepository extends CrudRepository<OrderItemDto, String> {
}
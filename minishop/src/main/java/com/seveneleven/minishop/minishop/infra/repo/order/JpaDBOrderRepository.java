package com.seveneleven.minishop.minishop.infra.repo.order;

import org.springframework.data.repository.CrudRepository;

import com.seveneleven.minishop.minishop.infra.dto.OrderDto;

public interface JpaDBOrderRepository extends CrudRepository<OrderDto, String> {
}
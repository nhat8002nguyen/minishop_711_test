package com.seveneleven.minishop.minishop.infra.repo.orderItem;

import org.springframework.beans.factory.annotation.Autowired;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.OrderItem;
import com.seveneleven.minishop.minishop.infra.entities.OrderItemEntity;
import com.seveneleven.minishop.minishop.infra.mappers.OrderMapper;
import com.seveneleven.minishop.minishop.repositories.OrderItemRepository;

public class JpaOrderItemRepository implements OrderItemRepository {

	@Autowired
	private JpaDBOrderItemRepository repository;

	private OrderMapper mapper = OrderMapper.INSTANCE;

	@Override
	public OrderItem save(Order order, OrderItem orderItem) {
		OrderItemEntity entity = mapper.orderItemPojoToEntity(order, orderItem);
		OrderItemEntity savedEntity = repository.save(entity);
		return mapper.orderItemEntityToPojo(savedEntity);
	}
}

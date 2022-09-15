package com.seveneleven.minishop.minishop.infra.dto.mappers;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;
import com.seveneleven.minishop.minishop.domain.domainObjects.order.OrderItem;
import com.seveneleven.minishop.minishop.infra.dto.OrderDto;
import com.seveneleven.minishop.minishop.infra.dto.OrderItemDto;

@Mapper(imports = UUID.class)
public interface OrderMapper {
	public OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	@Mapping(ignore = true, target = "id")
	OrderDto toOrderDto(Order order);

	Order dtoToOrder(OrderDto order);

	@Mapping(target = "id", expression = "java( UUID.randomUUID().toString() )")
	@Mapping(target = "product.id", ignore = true)
	OrderItemDto toOrderItemDto(OrderItem order);

	OrderItem orderItemDtotoOrderItem(OrderItemDto orderItemDto);
}

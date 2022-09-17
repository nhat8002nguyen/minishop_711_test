package com.seveneleven.minishop.minishop.infra.mappers;

import java.util.Date;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.infra.dto.OrderDto;

@Mapper(imports = UUID.class)
public interface OrderMapper {
	public OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	@Mapping(target = "id", expression = "java( UUID.randomUUID().toString() )")
	OrderDto toOrderDto(Order order);

	Order dtoToOrder(OrderDto order);

	@Mapping(source = "firstCreatedAt", target = "placedAt")
	@Mapping(source = "sourceId", target = "id")
	OrderDto updateOrderDto(String sourceId, Date firstCreatedAt, Order order);
}

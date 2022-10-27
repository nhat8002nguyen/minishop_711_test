package com.seveneleven.minishop.minishop.infra.mappers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.OrderItem;
import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.domain.order.User;
import com.seveneleven.minishop.minishop.infra.entities.OrderEntity;
import com.seveneleven.minishop.minishop.infra.entities.OrderItemEntity;
import com.seveneleven.minishop.minishop.infra.entities.ProductEntity;
import com.seveneleven.minishop.minishop.infra.entities.UserEntity;

@Mapper(imports = UUID.class)
public abstract class OrderMapper {
	public static OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	@AfterMapping
	void setAssociateOrderForOrderItem(@MappingTarget OrderEntity orderItemEntity) {
		List<OrderItemEntity> orderItemEntities = orderItemEntity.getOrderItems();
		orderItemEntities.forEach(item -> item.setOrder(orderItemEntity));
	}

	public abstract OrderEntity orderPojoToEntity(Order order);

	public abstract Order orderEntityToPojo(OrderEntity order);

	@Mapping(source = "firstCreatedAt", target = "placedAt")
	@Mapping(source = "sourceId", target = "id")
	public abstract OrderEntity updateOrderEntity(long sourceId, Date firstCreatedAt, Order order);

	public abstract OrderItem orderItemEntityToPojo(OrderItemEntity entity);

	@Mapping(target = "order", ignore = true)
	public abstract OrderItemEntity orderItemPojoToEntity(OrderItem orderItem);

	@Mapping(target = "orderItems", ignore = true)
	public abstract ProductEntity productEntityToPojo(Product product);

	@Mapping(source = "firstCreatedAt", target = "createdAt")
	@Mapping(source = "sourceId", target = "id")
	@Mapping(target = "orderItems", ignore = true)
	public abstract ProductEntity updateProductEntityCompletely(long sourceId, Date firstCreatedAt,
			Product product);

	public abstract Product productEntityToPojo(ProductEntity productDto);

	public abstract User userEntityToUser(UserEntity userEntity);

	@Mapping(target = "orders", ignore = true)
	public abstract UserEntity userPojoToEntity(User pojo);
}

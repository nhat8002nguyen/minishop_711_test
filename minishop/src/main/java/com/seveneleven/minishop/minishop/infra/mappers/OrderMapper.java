package com.seveneleven.minishop.minishop.infra.mappers;

import java.util.Date;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
public interface OrderMapper {
	public OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	OrderEntity orderPojoToEntity(Order order);

	Order orderEntityToPojo(OrderEntity order);

	@Mapping(source = "firstCreatedAt", target = "placedAt")
	@Mapping(source = "sourceId", target = "id")
	OrderEntity updateOrderEntity(long sourceId, Date firstCreatedAt, Order order);

	OrderItem orderItemEntityToPojo(OrderItemEntity entity);

	@Mapping(source = "orderItem.id", target = "id")
	OrderItemEntity orderItemPojoToEntity(Order order, OrderItem orderItem);

	@Mapping(target = "orderItems", ignore = true)
	ProductEntity productEntityToPojo(Product product);

	@Mapping(source = "firstCreatedAt", target = "createdAt")
	@Mapping(source = "sourceId", target = "id")
	@Mapping(target = "orderItems", ignore = true)
	ProductEntity updateProductEntityCompletely(long sourceId, Date firstCreatedAt, Product product);

	Product productEntityToPojo(ProductEntity productDto);

	User userEntityToUser(UserEntity userEntity);

	@Mapping(target = "orders", ignore = true)
	UserEntity userPojoToEntity(User pojo);
}

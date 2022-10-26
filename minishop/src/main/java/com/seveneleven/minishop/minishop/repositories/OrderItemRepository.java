package com.seveneleven.minishop.minishop.repositories;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.OrderItem;

public interface OrderItemRepository {
	OrderItem save(Order order, OrderItem orderItem);
}

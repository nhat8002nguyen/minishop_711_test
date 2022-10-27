package com.seveneleven.minishop.minishop.repositories;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.OrderItem;

public interface OrderItemRepository {
	OrderItem saveOrderItem(Order order, OrderItem orderItem);
}

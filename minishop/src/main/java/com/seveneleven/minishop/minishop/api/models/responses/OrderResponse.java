package com.seveneleven.minishop.minishop.api.models.responses;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.User;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class OrderResponse {
	private final Order order;
	private final User customer;
}

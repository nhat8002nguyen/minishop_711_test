package com.seveneleven.minishop.minishop.domain.order;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItem {
	private final String id;

	private final Product product;

	private final int quantity;

	private final Date createdAt;

	private final Date updatedAt;

	private final BigDecimal totalPrice;
}

package com.seveneleven.minishop.minishop.domain.domainObjects.order;

import java.util.Date;
import java.util.List;

import com.seveneleven.minishop.minishop.domain.domainObjects.customer.Customer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
	private String id;

	private Customer customer;

	private final List<OrderItem> orderItems;

	private final Date placedAt;
}

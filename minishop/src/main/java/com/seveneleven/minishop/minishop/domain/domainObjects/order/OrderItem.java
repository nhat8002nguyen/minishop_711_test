package com.seveneleven.minishop.minishop.domain.domainObjects.order;

import java.math.BigDecimal;
import java.util.Date;

import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;

import lombok.Data;

@Data
public class OrderItem {
	private String id;

	private Product product;

	private int quantity;

	private Date createdAt;

	private Date updatedAt;

	private BigDecimal totalPrice;

}

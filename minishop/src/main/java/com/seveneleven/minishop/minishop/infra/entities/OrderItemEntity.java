package com.seveneleven.minishop.minishop.infra.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "order_items")
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Builder
public class OrderItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private ProductEntity product;

	@ManyToOne
	private OrderEntity order;

	@Size(min = 1, message = "Item should have at least 1 product")
	private int quantity;

	private BigDecimal totalPrice;

	@UpdateTimestamp
	private Date updatedAt;

	@CreationTimestamp
	private Date createdAt;
}

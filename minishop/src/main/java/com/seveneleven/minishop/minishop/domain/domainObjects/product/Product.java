package com.seveneleven.minishop.minishop.domain.domainObjects.product;

import java.math.BigDecimal;
import java.util.Date;

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
public class Product {
	private String id;

	private final String title;

	private final String description;

	private final String imageUrl;

	private final BigDecimal price;

	private final Boolean instock;

	private final Date updatedAt;

	private final Date createdAt;
}

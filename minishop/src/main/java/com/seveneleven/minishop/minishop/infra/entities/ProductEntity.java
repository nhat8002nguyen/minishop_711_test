package com.seveneleven.minishop.minishop.infra.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity(name = "products")
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final long id;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 1000, message = "Product title should min 5 and max 1000 characters long")
	private final String title;

	@Size(max = 10000, message = "Description of a product has maximum 10000 characters")
	private final String description;

	@NotNull
	private final String imageUrl;

	@NotNull
	@Size(min = 1, max = 1000000000, message = "Price should be enter truely")
	private final BigDecimal price;

	@NotNull
	private final Boolean inStock;

	@OneToMany(mappedBy = "product")
	private final List<OrderItemEntity> orderItems;

	@UpdateTimestamp
	private Date updatedAt;

	@CreationTimestamp
	private Date createdAt;
}

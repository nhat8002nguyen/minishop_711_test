package com.seveneleven.minishop.minishop.infra.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class ProductDto {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

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
	private final String price;

	@NotNull
	private final Boolean instock;

	@UpdateTimestamp
	private Date updatedAt;

	@CreationTimestamp
	private Date createdAt;
}

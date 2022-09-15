package com.seveneleven.minishop.minishop.infra.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
public class CustomerDto {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@NotNull
	@Size(min = 5, max = 100, message = "Username has characters long between 5 and 100, inclusively")
	private String username;

	@NotNull
	private String email;

	@NotNull
	private String password;

	@CreationTimestamp
	private final Date registerDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private final List<OrderDto> orders = new ArrayList<>();
}
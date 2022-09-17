package com.seveneleven.minishop.minishop.infra.mappers;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.seveneleven.minishop.minishop.domain.order.Customer;
import com.seveneleven.minishop.minishop.infra.dto.CustomerDto;

@Mapper(imports = UUID.class)
public interface CustomerMapper {
	public CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	Customer customerDtoToCustomer(CustomerDto customerDto);
}
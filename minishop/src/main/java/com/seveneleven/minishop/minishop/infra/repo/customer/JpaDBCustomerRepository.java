package com.seveneleven.minishop.minishop.infra.repo.customer;

import org.springframework.data.repository.CrudRepository;

import com.seveneleven.minishop.minishop.infra.dto.CustomerDto;

public interface JpaDBCustomerRepository extends CrudRepository<CustomerDto, String> {
	CustomerDto findByUsername(String name);
}
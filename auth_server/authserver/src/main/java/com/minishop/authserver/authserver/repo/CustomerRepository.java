package com.minishop.authserver.authserver.repo;

import org.springframework.data.repository.CrudRepository;

import com.minishop.authserver.authserver.Entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findByUsername(String username);
}

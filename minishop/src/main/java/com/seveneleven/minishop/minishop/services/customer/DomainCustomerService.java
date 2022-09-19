package com.seveneleven.minishop.minishop.services.customer;

import com.seveneleven.minishop.minishop.domain.order.Customer;
import com.seveneleven.minishop.minishop.repositories.CustomerRepository;

public class DomainCustomerService implements CustomerService {
	private final CustomerRepository customerRepository;

	public DomainCustomerService(
			CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomerByName(String name) {
		return customerRepository.findCustomerByName(name);
	}

}

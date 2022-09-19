package com.seveneleven.minishop.minishop.services.customer;

import com.seveneleven.minishop.minishop.domain.order.Customer;

public interface CustomerService {
	Customer getCustomerByName(String name);
}

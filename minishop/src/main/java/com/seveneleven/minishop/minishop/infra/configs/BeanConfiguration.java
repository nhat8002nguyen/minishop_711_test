package com.seveneleven.minishop.minishop.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seveneleven.minishop.minishop.repositories.CustomerRepository;
import com.seveneleven.minishop.minishop.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;
import com.seveneleven.minishop.minishop.services.customer.CustomerService;
import com.seveneleven.minishop.minishop.services.customer.DomainCustomerService;
import com.seveneleven.minishop.minishop.services.order.DomainOrderService;
import com.seveneleven.minishop.minishop.services.order.OrderService;
import com.seveneleven.minishop.minishop.services.product.DomainProductService;
import com.seveneleven.minishop.minishop.services.product.ProductService;

@Configuration
public class BeanConfiguration {
	@Bean
	ProductService productService(ProductRepository productRepo) {
		return new DomainProductService(productRepo);
	}

	@Bean
	CustomerService customerService(
			CustomerRepository customerRepository) {
		return new DomainCustomerService(customerRepository);
	}

	@Bean
	OrderService orderService(
			OrderRepository orderRepository,
			CustomerRepository customerRepository) {
		return new DomainOrderService(orderRepository, customerRepository);
	}

}

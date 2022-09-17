package com.seveneleven.minishop.minishop.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seveneleven.minishop.minishop.repositories.CustomerRepository;
import com.seveneleven.minishop.minishop.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;
import com.seveneleven.minishop.minishop.services.admin.AdminService;
import com.seveneleven.minishop.minishop.services.admin.DomainAdminService;
import com.seveneleven.minishop.minishop.services.customer.CustomerService;
import com.seveneleven.minishop.minishop.services.customer.DomainCustomerService;
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
			OrderRepository orderRepository,
			ProductRepository productRepository,
			CustomerRepository customerRepository) {
		return new DomainCustomerService(orderRepository, productRepository, customerRepository);
	}

	@Bean
	AdminService adminService(
			ProductRepository productRepository,
			OrderRepository orderRepository) {
		return new DomainAdminService(productRepository, orderRepository);
	}
}

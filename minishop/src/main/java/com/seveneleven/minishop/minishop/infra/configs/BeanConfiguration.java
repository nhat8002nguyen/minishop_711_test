package com.seveneleven.minishop.minishop.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seveneleven.minishop.minishop.domain.domainObjects.admin.DomainAdminService;
import com.seveneleven.minishop.minishop.domain.domainObjects.customer.DomainCustomerService;
import com.seveneleven.minishop.minishop.domain.domainObjects.product.DomainProductService;
import com.seveneleven.minishop.minishop.domain.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.domain.repositories.ProductRepository;
import com.seveneleven.minishop.minishop.domain.services.AdminService;
import com.seveneleven.minishop.minishop.domain.services.CustomerService;
import com.seveneleven.minishop.minishop.domain.services.ProductService;

@Configuration
public class BeanConfiguration {
	@Bean
	ProductService productService(ProductRepository productRepo) {
		return new DomainProductService(productRepo);
	}

	@Bean
	CustomerService customerService(
			OrderRepository orderRepository,
			ProductRepository productRepository) {
		return new DomainCustomerService(orderRepository, productRepository);
	}

	@Bean
	AdminService adminService(
			ProductRepository productRepository,
			OrderRepository orderRepository) {
		return new DomainAdminService(productRepository, orderRepository);
	}
}

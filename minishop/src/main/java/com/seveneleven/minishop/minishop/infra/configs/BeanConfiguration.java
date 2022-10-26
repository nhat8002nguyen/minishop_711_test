package com.seveneleven.minishop.minishop.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seveneleven.minishop.minishop.domain.services.order.DomainOrderService;
import com.seveneleven.minishop.minishop.domain.services.order.OrderService;
import com.seveneleven.minishop.minishop.domain.services.product.DomainProductService;
import com.seveneleven.minishop.minishop.domain.services.product.ProductService;
import com.seveneleven.minishop.minishop.domain.services.user.DomainUserService;
import com.seveneleven.minishop.minishop.domain.services.user.UserService;
import com.seveneleven.minishop.minishop.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.repositories.ProductRepository;
import com.seveneleven.minishop.minishop.repositories.UserRepository;

@Configuration
public class BeanConfiguration {
	@Bean
	ProductService productService(ProductRepository productRepo) {
		return new DomainProductService(productRepo);
	}

	@Bean
	UserService customerService(
			UserRepository customerRepository) {
		return new DomainUserService(customerRepository);
	}

	@Bean
	OrderService orderService(
			OrderRepository orderRepository,
			UserRepository customerRepository) {
		return new DomainOrderService(orderRepository, customerRepository);
	}
}

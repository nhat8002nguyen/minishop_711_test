package com.seveneleven.minishop.minishop.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seveneleven.minishop.minishop.domain.domainObjects.product.DomainProductService;
import com.seveneleven.minishop.minishop.domain.repositories.ProductRepository;
import com.seveneleven.minishop.minishop.domain.services.ProductService;

@Configuration
public class BeanConfiguration {
	@Bean
	ProductService productService(ProductRepository productRepo) {
		return new DomainProductService(productRepo);
	}
}

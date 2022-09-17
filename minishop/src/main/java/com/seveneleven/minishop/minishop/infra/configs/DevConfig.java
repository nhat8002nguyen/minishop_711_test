package com.seveneleven.minishop.minishop.infra.configs;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.seveneleven.minishop.minishop.infra.dto.CustomerDto;
import com.seveneleven.minishop.minishop.infra.dto.ProductDto;
import com.seveneleven.minishop.minishop.infra.repo.customer.JpaDBCustomerRepository;
import com.seveneleven.minishop.minishop.infra.repo.product.JpaDBProductRepository;

@Configuration
public class DevConfig {
	@Bean
	ApplicationRunner dataLoader(
			PasswordEncoder passwordEncoder,
			JpaDBProductRepository productRepo,
			JpaDBCustomerRepository customerRepo) {
		return args -> {
			ProductDto productDto1 = ProductDto.builder()
					.id("product-abc-123")
					.title("product 1")
					.description("This is product 1")
					.imageUrl("this is image URL")
					.price(BigDecimal.valueOf(12000))
					.instock(true)
					.build();

			ProductDto productDto2 = ProductDto.builder()
					.id("product-abc-124")
					.title("product 1")
					.description("This is product 1")
					.imageUrl("this is image URL")
					.price(BigDecimal.valueOf(12000))
					.instock(true)
					.build();

			ProductDto productDto3 = ProductDto.builder()
					.id("product-abc-125")
					.title("product 1")
					.description("This is product 1")
					.imageUrl("this is image URL")
					.price(BigDecimal.valueOf(12000))
					.instock(true)
					.build();

			productRepo.saveAll(Arrays.asList(productDto1, productDto2, productDto3));

			CustomerDto customer1 = CustomerDto.builder()
					.email("aominenguyendu@gmail.com")
					.username("customer")
					.password(passwordEncoder.encode("customer"))
					.build();

			CustomerDto admin = CustomerDto.builder()
					.email("aominenguyendu@gmail.com")
					.username("admin")
					.password(passwordEncoder.encode("admin"))
					.build();

			customerRepo.saveAll(Arrays.asList(customer1, admin));
		};
	}
}

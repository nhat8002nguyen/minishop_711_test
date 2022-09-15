package com.seveneleven.minishop.minishop.infra.configs;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seveneleven.minishop.minishop.domain.domainObjects.product.Product;
import com.seveneleven.minishop.minishop.infra.dto.ProductDto;
import com.seveneleven.minishop.minishop.infra.dto.mappers.ProductMapper;
import com.seveneleven.minishop.minishop.infra.repo.JpaDBProductRepository;

@Configuration
public class DevConfig {
	@Bean
	ApplicationRunner dataLoader(
			JpaDBProductRepository productRepo) {
		return args -> {
			Product product1 = Product.builder()
					.id("123")
					.title("product 1")
					.description("This is product 1")
					.imageUrl("this is image URL")
					.price(BigDecimal.valueOf(12000))
					.instock(true)
					.build();
			ProductDto productDto1 = ProductMapper.INSTANCE.productToProductDto(product1);

			Product product2 = Product.builder()
					.id("124")
					.title("product 1")
					.description("This is product 1")
					.imageUrl("this is image URL")
					.price(BigDecimal.valueOf(12000))
					.instock(true)
					.build();
			ProductDto productDto2 = ProductMapper.INSTANCE.productToProductDto(product2);

			Product product3 = Product.builder()
					.id("125")
					.title("product 1")
					.description("This is product 1")
					.imageUrl("this is image URL")
					.price(BigDecimal.valueOf(12000))
					.instock(true)
					.build();
			ProductDto productDto3 = ProductMapper.INSTANCE.productToProductDto(product3);

			productRepo.saveAll(Arrays.asList(productDto1, productDto2, productDto3));
		};
	}
}

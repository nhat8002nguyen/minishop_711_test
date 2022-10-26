package com.seveneleven.minishop.minishop.infra.configs;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.seveneleven.minishop.minishop.infra.repo.customer.JpaDBUserRepository;
import com.seveneleven.minishop.minishop.infra.repo.product.JpaDBProductRepository;

@Configuration
public class DevConfig {
	@Bean
	ApplicationRunner dataLoader(
			PasswordEncoder passwordEncoder,
			JpaDBProductRepository productRepo,
			JpaDBUserRepository userRepo) {
		return args -> {
			// ProductEntity productDto1 = ProductEntity.builder()
			// .title("product 1")
			// .description("This is product 1")
			// .imageUrl("this is image URL")
			// .price(BigDecimal.valueOf(12000))
			// .inStock(true)
			// .build();

			// ProductEntity productDto2 = ProductEntity.builder()
			// .title("product 1")
			// .description("This is product 1")
			// .imageUrl("this is image URL")
			// .price(BigDecimal.valueOf(12000))
			// .inStock(true)
			// .build();

			// ProductEntity productDto3 = ProductEntity.builder()
			// .title("product 1")
			// .description("This is product 1")
			// .imageUrl("this is image URL")
			// .price(BigDecimal.valueOf(12000))
			// .inStock(true)
			// .build();

			// productRepo.saveAll(Arrays.asList(productDto1, productDto2, productDto3));

			// UserEntity customer1 = UserEntity.builder()
			// .email("aominenguyendu@gmail.com")
			// .username("customer")
			// .password(passwordEncoder.encode("customer"))
			// .build();

			// UserEntity admin = UserEntity.builder()
			// .email("aominenguyendu@gmail.com")
			// .username("admin")
			// .password(passwordEncoder.encode("admin"))
			// .build();

			// userRepo.saveAll(Arrays.asList(customer1, admin));
		};
	}
}

package com.minishop.authserver.authserver.configs;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.minishop.authserver.authserver.Entities.Customer;
import com.minishop.authserver.authserver.repo.CustomerRepository;

@Configuration
public class DevConfig {

	@Bean
	public ApplicationRunner dataLoader(
			PasswordEncoder encoder,
			CustomerRepository customerRepo) {
		return args -> {
			Customer customer = Customer.builder()
					.username("customer")
					.password(encoder.encode("customer"))
					.role("ROLE_USER")
					.build();

			Customer admin = Customer.builder()
					.username("admin")
					.password(encoder.encode("admin"))
					.role("ROLE_ADMIN")
					.build();

			customerRepo.save(customer);
			customerRepo.save(admin);
		};
	}
}

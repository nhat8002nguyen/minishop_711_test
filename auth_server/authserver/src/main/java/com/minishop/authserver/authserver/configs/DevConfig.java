package com.minishop.authserver.authserver.configs;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.minishop.authserver.authserver.Entities.Admin;
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
					.username("Customer")
					.password(encoder.encode("password"))
					.build();

			Customer admin = Admin.builder()
					.username("admin")
					.password(encoder.encode("password"))
					.build();

			customerRepo.save(customer);
			customerRepo.save(admin);
		};
	}
}

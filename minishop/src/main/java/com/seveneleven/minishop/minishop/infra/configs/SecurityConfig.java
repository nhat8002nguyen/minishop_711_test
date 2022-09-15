package com.seveneleven.minishop.minishop.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/product")
				.permitAll()
				.antMatchers("/api/admin-service").hasRole("ADMIN")
				.antMatchers("/api/user-service").hasAnyRole("USER", "ADMIN")
				.antMatchers("/api/product").permitAll()
				.and()
				.formLogin()
				.and()
				.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

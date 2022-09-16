package com.seveneleven.minishop.minishop.infra.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

import com.seveneleven.minishop.minishop.infra.holders.JwtProps;

@EnableWebSecurity
public class SecurityConfig {
	private final JwtProps jwtProps;

	@Autowired
	public SecurityConfig(JwtProps jwtProps) {
		this.jwtProps = jwtProps;
	}

	@Bean
	@Order(1)
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeRequests((authorizeRequests) -> authorizeRequests
						.antMatchers("/api/product").hasAuthority("SCOPE_readProducts")

						.antMatchers("/api/admin-service/**")
						.hasAnyAuthority("SCOPE_writeProducts", "SCOPE_readOrders")

						.antMatchers("/api/customer-service/**")
						.hasAnyAuthority("SCOPE_writeOrders", "SCOPE_readOrders")

						.anyRequest().authenticated())
				.csrf().disable()
				.oauth2ResourceServer((oauth2ResourceServer) -> oauth2ResourceServer
						.jwt((jwt) -> jwt
								.decoder(jwtDecoder())));
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return JwtDecoders.fromIssuerLocation(jwtProps.getIssuerUri());
	}
}

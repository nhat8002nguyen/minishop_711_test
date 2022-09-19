package com.minishop.clientapp.clientapp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests(
				authorizeRequests -> authorizeRequests.anyRequest().authenticated())
				.oauth2Login(
						oauth2Login -> oauth2Login.loginPage("/oauth2/authorization/minishop-client-oidc"))
				.oauth2Client(Customizer.withDefaults());

		return http.build();
	}
}

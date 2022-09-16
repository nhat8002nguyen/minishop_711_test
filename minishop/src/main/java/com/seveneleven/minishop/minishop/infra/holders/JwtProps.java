package com.seveneleven.minishop.minishop.infra.holders;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.resourceserver.jwt")
@Data
public class JwtProps {
	private String issuerUri = "https://localhost:9000";
}

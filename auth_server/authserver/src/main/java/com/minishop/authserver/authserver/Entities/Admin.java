package com.minishop.authserver.authserver.Entities;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class Admin extends Customer {
	public Admin(long id, String username, String password) {
		super(id, username, password);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}

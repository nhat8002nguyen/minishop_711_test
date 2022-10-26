package com.seveneleven.minishop.minishop.domain.services.user;

import com.seveneleven.minishop.minishop.domain.order.User;
import com.seveneleven.minishop.minishop.repositories.UserRepository;

public class DomainUserService implements UserService {
	private final UserRepository userRepository;

	public DomainUserService(
			UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.findUserByName(name);
	}

}

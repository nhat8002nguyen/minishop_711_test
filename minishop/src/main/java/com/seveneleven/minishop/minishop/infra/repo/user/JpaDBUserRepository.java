package com.seveneleven.minishop.minishop.infra.repo.customer;

import org.springframework.data.repository.CrudRepository;

import com.seveneleven.minishop.minishop.infra.entities.UserEntity;

public interface JpaDBUserRepository extends CrudRepository<UserEntity, String> {
	UserEntity findByUsername(String name);
}
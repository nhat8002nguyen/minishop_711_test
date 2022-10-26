package com.seveneleven.minishop.minishop.infra.repo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seveneleven.minishop.minishop.domain.exceptions.user_exceptions.UserNotFoundException;
import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.User;
import com.seveneleven.minishop.minishop.infra.entities.OrderEntity;
import com.seveneleven.minishop.minishop.infra.entities.UserEntity;
import com.seveneleven.minishop.minishop.infra.mappers.OrderMapper;
import com.seveneleven.minishop.minishop.repositories.UserRepository;

@Component
public class JpaUserRepository implements UserRepository {
	private final JpaDBUserRepository userRepo;
	private final OrderMapper mapper = OrderMapper.INSTANCE;

	@Autowired
	public JpaUserRepository(JpaDBUserRepository userRepository) {
		this.userRepo = userRepository;
	}

	@Override
	public User findUserByName(String name) {
		return mapper.userEntityToUser(findUserByUsernameIfFound(name));
	}

	@Override
	public List<Order> getOrdersByUsername(String name) {
		UserEntity user = findUserByUsernameIfFound(name);
		List<OrderEntity> orders = user.getOrders();
		return orders.stream().map(mapper::orderEntityToPojo).collect(Collectors.toList());
	}

	@Override
	public Long createOrder(String username, Order order) {
		UserEntity user = findUserByUsernameIfFound(username);
		List<OrderEntity> oldOrders = user.getOrders();
		if (oldOrders == null) {
			oldOrders = new ArrayList<>();
		}
		OrderEntity newOrderDto = mapper.orderPojoToEntity(order);
		oldOrders.add(newOrderDto);
		userRepo.save(user);
		return newOrderDto.getId();
	}

	private UserEntity findUserByUsernameIfFound(String name) {
		UserEntity entity = userRepo.findByUsername(name);
		if (entity == null) {
			throw new UserNotFoundException(name);
		}
		return entity;
	}
}
package com.seveneleven.minishop.minishop.infra.repo.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.infra.entities.OrderEntity;
import com.seveneleven.minishop.minishop.infra.mappers.OrderMapper;
import com.seveneleven.minishop.minishop.repositories.OrderRepository;

@Component
public class JpaOrderRepository implements OrderRepository {
	private final JpaDBOrderRepository orderRepo;
	private final OrderMapper mapper = OrderMapper.INSTANCE;
	private final Log LOGGER = LogFactory.getLog(JpaDBOrderRepository.class);

	@Autowired
	public JpaOrderRepository(JpaDBOrderRepository orderRepository) {
		this.orderRepo = orderRepository;
	}

	@Override
	public Order createOrder(Order order) {
		OrderEntity orderDto = mapper.orderPojoToEntity(order);
		OrderEntity savedOrder = orderRepo.save(orderDto);
		LOGGER.info("Order was saved: " + savedOrder);
		return mapper.orderEntityToPojo(savedOrder);
	}

	@Override
	public void removeOrder(String id) {
		orderRepo.deleteById(id);
	}

	@Override
	public Order updateOrder(String id, Order order) {
		Optional<OrderEntity> optional = orderRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		OrderEntity oldOrderEntity = optional.get();

		OrderEntity updatedOrder = mapper.updateOrderEntity(
				oldOrderEntity.getId(),
				oldOrderEntity.getPlacedAt(),
				order);

		updatedOrder = orderRepo.save(updatedOrder);

		Order newOrder = mapper.orderEntityToPojo(updatedOrder);

		return newOrder;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		Iterable<OrderEntity> iterable = orderRepo.findAll();

		iterable.forEach(entity -> orders.add(mapper.orderEntityToPojo(entity)));
		return orders;
	}
}
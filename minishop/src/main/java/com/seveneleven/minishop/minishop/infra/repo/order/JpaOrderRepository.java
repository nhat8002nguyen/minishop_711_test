package com.seveneleven.minishop.minishop.infra.repo.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.infra.dto.OrderDto;
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
	public String createOrder(Order order) {
		OrderDto orderDto = mapper.toOrderDto(order);
		OrderDto savedOrder = orderRepo.save(orderDto);
		LOGGER.info("Order was saved: " + savedOrder);
		return savedOrder.getId();
	}

	@Override
	public void removeOrder(String id) {
		orderRepo.deleteById(id);
	}

	@Override
	public Order updateOrder(String id, Order order) {
		Optional<OrderDto> optional = orderRepo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		OrderDto oldOrderDto = optional.get();

		OrderDto updatedOrder = mapper.updateOrderDto(
				oldOrderDto.getId(),
				oldOrderDto.getPlacedAt(),
				order);

		updatedOrder = orderRepo.save(updatedOrder);

		Order newOrder = mapper.dtoToOrder(updatedOrder);

		return newOrder;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> productList = new ArrayList<>();
		Iterable<OrderDto> iterable = orderRepo.findAll();

		iterable.forEach(orderDto -> productList.add(mapper.dtoToOrder(orderDto)));
		return productList;
	}
}
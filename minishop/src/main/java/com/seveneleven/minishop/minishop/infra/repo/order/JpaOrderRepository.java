package com.seveneleven.minishop.minishop.infra.repo.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seveneleven.minishop.minishop.domain.domainObjects.order.Order;
import com.seveneleven.minishop.minishop.domain.repositories.OrderRepository;
import com.seveneleven.minishop.minishop.infra.dto.OrderDto;
import com.seveneleven.minishop.minishop.infra.dto.mappers.OrderMapper;

@Component
public class JpaOrderRepository implements OrderRepository {
	private final JpaDBOrderRepository orderRepo;
	private final OrderMapper mapper = OrderMapper.INSTANCE;

	@Autowired
	public JpaOrderRepository(JpaDBOrderRepository orderRepository) {
		this.orderRepo = orderRepository;
	}

	@Override
	public String createOrder(Order order) {
		OrderDto orderDto = mapper.toOrderDto(order);
		orderRepo.save(orderDto);
		return orderDto.getId();
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

	@Override
	public List<Order> getOrdersByCustomer(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
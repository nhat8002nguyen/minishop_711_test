package com.seveneleven.minishop.minishop.infra.repo.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seveneleven.minishop.minishop.domain.order.Customer;
import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.infra.dto.CustomerDto;
import com.seveneleven.minishop.minishop.infra.dto.OrderDto;
import com.seveneleven.minishop.minishop.infra.mappers.CustomerMapper;
import com.seveneleven.minishop.minishop.infra.mappers.OrderMapper;
import com.seveneleven.minishop.minishop.repositories.CustomerRepository;

@Component
public class JpaCustomerRepository implements CustomerRepository {
	private final JpaDBCustomerRepository customerRepo;
	private final CustomerMapper mapper = CustomerMapper.INSTANCE;
	private final OrderMapper orderMapper = OrderMapper.INSTANCE;
	private final Log LOGGER = LogFactory.getLog(JpaCustomerRepository.class);

	@Autowired
	public JpaCustomerRepository(JpaDBCustomerRepository customerRepository) {
		this.customerRepo = customerRepository;
	}

	@Override
	public Customer findCustomerByName(String name) {
		return mapper.customerDtoToCustomer(customerRepo.findByUsername(name));
	}

	@Override
	public List<Order> getOrdersByUsername(String name) {
		CustomerDto customer = customerRepo.findByUsername(name);
		List<OrderDto> orders = customer.getOrders();
		return orders.stream().map(orderMapper::dtoToOrder).collect(Collectors.toList());
	}

	@Override
	public String createOrder(String username, Order order) {
		CustomerDto customer = customerRepo.findByUsername(username);
		List<OrderDto> oldOrders = customer.getOrders();
		OrderDto newOrderDto = orderMapper.toOrderDto(order);
		oldOrders.add(newOrderDto);
		customerRepo.save(customer);
		return newOrderDto.getId();
	}

}
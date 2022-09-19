package com.seveneleven.minishop.minishop.api.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seveneleven.minishop.minishop.api.models.request.order.ItemRequest;
import com.seveneleven.minishop.minishop.api.models.request.order.OrderRequest;
import com.seveneleven.minishop.minishop.domain.order.Customer;
import com.seveneleven.minishop.minishop.domain.order.Order;
import com.seveneleven.minishop.minishop.domain.order.OrderItem;
import com.seveneleven.minishop.minishop.domain.order.Product;
import com.seveneleven.minishop.minishop.services.customer.CustomerService;
import com.seveneleven.minishop.minishop.services.order.OrderService;
import com.seveneleven.minishop.minishop.services.product.ProductService;

@RestController
@RequestMapping(path = "/api/customer-service", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class CustomerController {
	private final CustomerService customerService;
	private final ProductService productService;
	private final OrderService orderService;

	@Autowired
	public CustomerController(
			CustomerService service,
			ProductService productService,
			OrderService orderService) {
		this.customerService = service;
		this.productService = productService;
		this.orderService = orderService;
	}

	@GetMapping(path = "{customerName}/order")
	public ResponseEntity<?> getOrders(@PathVariable String customerName) {
		List<Order> orders = orderService.getOrdersOfCustomer(customerName);
		if (orders == null) {
			return ResponseEntity.badRequest().body(Map.of("message", "Cannot get order list"));
		}
		return ResponseEntity.ok(Map.of("orders", orders));
	}

	@PostMapping(path = "{customerName}/order")
	public ResponseEntity<?> placeOrder(@PathVariable String customerName, @RequestBody OrderRequest orderRequest) {
		try {
			Customer customer = customerService.getCustomerByName(customerName);

			if (customer == null) {
				return ResponseEntity.badRequest().body(Map.of("message", "Customer resource not found"));
			}

			String orderId = placeOrderByCustomer(customer, orderRequest);

			if (orderId == null) {
				return ResponseEntity.badRequest().body(Map.of("message", "Create Order fail"));
			}

			return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("orderId", orderId));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
		}
	}

	private String placeOrderByCustomer(Customer customer, OrderRequest orderRequest) throws Exception {
		List<OrderItem> orderItems = new ArrayList<>();

		List<ItemRequest> itemRequests = orderRequest.getItems();
		for (int i = 0; i < itemRequests.size(); i++) {
			OrderItem orderItem = createOrderItem(itemRequests.get(i));
			orderItems.add(orderItem);
		}

		if (orderItems.isEmpty())
			throw new Exception("Some order items can not be created");

		Order order = Order.builder()
				.customer(customer)
				.orderItems(orderItems)
				.build();

		String orderId = orderService.placeOrder(customer.getUsername(), order);
		return orderId;
	}

	private OrderItem createOrderItem(ItemRequest item) throws Exception {
		String productId = item.getProductId();
		Product product = productService.getProductDetail(item.getProductId());
		if (product == null) {
			throw new Exception("Product " + productId + " not found");
		}

		int quantity = item.getQuantity();

		if (quantity <= 0) {
			throw new Exception("Quantity is not true");
		}

		BigDecimal price = product.getPrice().multiply(BigDecimal.valueOf(quantity));

		return OrderItem.builder()
				.product(product)
				.quantity(item.getQuantity())
				.totalPrice(price)
				.build();
	}
}

package com.example.demo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.OrderCustomer;
import com.example.demo.model.entities.OrderLine;

public interface CustomerService {
	
	
	// CRUD de customer
	public boolean save(Customer customer);

	// CRUD de Items

	// CRUD de Order
	public boolean save(OrderCustomer order);

	public Optional<OrderCustomer> getOrder(Long id);
	
	// funcionalidades extra
	public boolean addLine(Long orderCustomerId,OrderLine line);
	public List<OrderCustomer> getAllOrders();

	/**
	 * Entrega una lista de Clientes que superan una cantidad minima
	 */
	List<Customer> getCustomersMinimumAmount(List<OrderCustomer> orders, BigDecimal minimunQuantity);
}

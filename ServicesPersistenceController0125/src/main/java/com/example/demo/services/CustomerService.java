package com.example.demo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.dtos.CustomerDTO;
import com.example.demo.model.dtos.CustomerNewDTO;
import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.OrderCustomer;
import com.example.demo.model.entities.OrderLine;
import com.example.demo.model.responses.CustomerNewResponse;

public interface CustomerService {
	public Optional<CustomerDTO> getCustomerDTO(Long id);
	public Optional<Customer> findCustomerById(Long orderCustomerId);

	//Commit:002
	public CustomerNewResponse addNewCustomer(CustomerNewDTO customer);
	
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

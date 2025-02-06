package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.dtos.CustomerDTO;
import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.Item;
import com.example.demo.model.entities.OrderCustomer;
import com.example.demo.model.entities.OrderLine;
import com.example.demo.model.mapper.CustomerDTOMapper;
import com.example.demo.populaters.Populaters;

@Service
public class CustomerServiceImpl implements CustomerService {

	private List<Customer> customers;
	private List<Item> items;
	private List<OrderCustomer> orders;
	//Commit:001
	private final CustomerDTOMapper customerDTOMapper;
	
	public CustomerServiceImpl(CustomerDTOMapper customerDTOMapper) {
		super();
		this.customerDTOMapper = customerDTOMapper;
		customers=new ArrayList<>();
		Customer e = new Customer("Jimeno","22","under the bridge");
		e.setId(1l);
		customers.add(e);
	}
	@Override
	public Optional<CustomerDTO> getCustomerDTO(Long id) {
		return findCustomerById(id)
				.map(customer->Optional.of(customerDTOMapper.mapToDTO(customer)))
				.orElse(Optional.empty());
	}
	/**
	 * Esto lo debe hacer el repo
	 */
	@Override
	public Optional<Customer> findCustomerById(Long orderCustomerId) {
		return customers
				.stream()
				.filter(customer->customer.getId().equals(orderCustomerId))
				.findFirst();
	}
	

	//Commit:001 
	
	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(OrderCustomer order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<OrderCustomer> getOrder(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

//	@Override
//	public boolean addLine(Long orderCustomerId, OrderLine line) {
////		Optional<OrderCustomer> orderCustomer = findCustomerById(orderCustomerId);
////		if (orderCustomer.isPresent()) {
////			return orderCustomer.get().addLine(line);
////		}
////		return false;
//		return findOrderCustomerById(orderCustomerId)
//			.map(order->order.addLine(line))
//			.orElse(false);
//			
//	}

	private Optional<CustomerDTO> findOrderCustomerById(Long orderCustomerId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<OrderCustomer> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomersMinimumAmount(List<OrderCustomer> orders, BigDecimal minimunQuantity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addLine(Long orderCustomerId, OrderLine line) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

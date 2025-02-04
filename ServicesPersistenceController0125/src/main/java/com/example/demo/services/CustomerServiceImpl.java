package com.example.demo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.Item;
import com.example.demo.model.entities.OrderCustomer;
import com.example.demo.model.entities.OrderLine;
import com.example.demo.populaters.Populaters;

@Service
public class CustomerServiceImpl implements CustomerService {

	private List<Customer> customers;
	private List<Item> items;
	private List<OrderCustomer> orders;

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

	@Override
	public boolean addLine(Long orderCustomerId, OrderLine line) {
//		Optional<OrderCustomer> orderCustomer = findCustomerById(orderCustomerId);
//		if (orderCustomer.isPresent()) {
//			return orderCustomer.get().addLine(line);
//		}
//		return false;
		return findCustomerById(orderCustomerId)
			.map(order->order.addLine(line))
			.orElse(false);
			
	}

	private Optional<OrderCustomer> findCustomerById(Long orderCustomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderCustomer> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Entrega una lista de Clientes que superan una cantidad minima
	 */
	@Override
	public List<Customer> getCustomersMinimumAmount(List<OrderCustomer> orders, BigDecimal minimunQuantity) {
		// TODO Auto-generated method stub
		return null;
	}
}

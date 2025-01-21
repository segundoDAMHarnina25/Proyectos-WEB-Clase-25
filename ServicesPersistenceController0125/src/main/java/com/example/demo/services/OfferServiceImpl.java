package com.example.demo.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.OrderCustomer;

@Service
public class OfferServiceImpl implements OfferService{

	@Override
	public List<Customer> madeOffer(List<OrderCustomer> orders, BigDecimal minimunQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

}

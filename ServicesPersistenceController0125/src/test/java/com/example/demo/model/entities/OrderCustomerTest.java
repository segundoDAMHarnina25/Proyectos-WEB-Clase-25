package com.example.demo.model.entities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.repositories.CustomerRepository;
import com.example.demo.model.repositories.ItemRepository;

@SpringBootTest
class OrderCustomerTest {

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@Test
	void testAddLine() {
		OrderCustomer orderCustomer=new OrderCustomer(LocalDate.now(), customerRepository.findById(1L).get());
		Item byId = itemRepository.findById(10L).get();
		OrderLine line1 = new OrderLine(byId,1,orderCustomer);
		assertTrue(orderCustomer.addLine(line1));
		assertFalse(orderCustomer.addLine(line1));
		OrderLine line2 = new OrderLine(byId,1,orderCustomer);
		assertFalse(orderCustomer.addLine(line2));
	}

}

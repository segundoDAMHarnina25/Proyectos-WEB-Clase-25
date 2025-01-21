package com.example.demo.model.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class OrderCustomerTest {

	@Test
	void testAddLine() {
		OrderCustomer order=new OrderCustomer(1l, LocalDate.now(), new Customer(1l,"felipe"));
		Item item = new Item(1l, "tornillo", 0, 0, 0,new BigDecimal(10));
		OrderLine line = new OrderLine(1,item,1);
		assertTrue(order.addLine(line));
		assertFalse(order.addLine(line));
		OrderLine line2 = new OrderLine(1,item,1);
		assertFalse(order.addLine(line2));
	}

}

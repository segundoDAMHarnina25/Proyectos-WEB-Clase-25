package com.example.demo.model.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entities.OrderLine;

@SpringBootTest
class OrderLineRepositoryTest {
	@Autowired
	OrderLineRepository orderLineRepository;

	@Test
	void testSave() {
		List<OrderLine> all = orderLineRepository.findAll();
		if (all.size() == 0)
			fail("Not yet implemented");
		try {
			OrderLine orderLine = all.get(0);
			OrderLine duplicado = new OrderLine(orderLine.getItem(), orderLine.getQuantity()+1,
					orderLine.getOrderCustomer());
			orderLineRepository.save(duplicado);
			fail("deberia fallar al duplicar");
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(true);
		}
	}

}

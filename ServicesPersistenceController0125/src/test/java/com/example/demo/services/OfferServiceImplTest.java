package com.example.demo.services;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.example.demo.model.entities.OrderCustomer;

@SpringBootTest
class OfferServiceImplTest {
	
	@Autowired
	OfferServiceImpl offerService;
	//No esta implementado
	@MockitoBean
	CustomerServiceImpl customerService;

	@Test
	void testMadeOffer() {
		/*
		 * Aqui hago toda la movida para poder probar
		 */
		when(customerService.getAllOrders()).thenReturn(List.of());
		List<OrderCustomer> allOrders = customerService.getAllOrders();
		// en al siguiente llamada tendremos la lista vacia
		offerService.madeOffer(allOrders, new BigDecimal(100));
	}

}

package com.example.demo.services;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.Offer;
import com.example.demo.model.entities.OrderCustomer;
import com.example.demo.model.repositories.OrderCustomerRepository;

@SpringBootTest
class OfferServiceImplTest {
	
	@Autowired
	OfferServiceImpl offerService;
	//No esta implementado
	@MockitoBean
	CustomerServiceImpl customerService;
	@Autowired
	OrderCustomerRepository orderCustomerRepository;

	@Test
	void testMadeOffer() {
		/*
		 * Aqui hago toda la movida para poder probar
		 */
		when(customerService.getAllOrders()).thenReturn(orderCustomerRepository.findAll());
		List<OrderCustomer> allOrders = customerService.getAllOrders();
		// en al siguiente llamada tendremos la lista vacia
		List<Customer> customersMinimumAmount = customerService.getCustomersMinimumAmount(allOrders, new BigDecimal(100));
		Map<Customer, Offer> madeOffer = offerService.madeOffer(customersMinimumAmount,new Offer());
	}

}

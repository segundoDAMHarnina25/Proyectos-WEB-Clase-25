package com.example.demo.services;

import java.util.List;
import java.util.Map;

import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.Offer;

public interface OfferService {
	//CRUD
	
	
	//Cosas especiales
	/**
	 * Basandose en la cantidad de pedidos total, hace una oferta, a los 
	 * clientes que sobrepasan una cantidad
	 * @param orders totales
	 * @param minimunQuantity que hay que superar
	 * @return los clientes que la superan
	 */
	public  Map<Customer,Offer> madeOffer(List<Customer> customer,Offer offer);
}

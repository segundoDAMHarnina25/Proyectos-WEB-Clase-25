package com.example.demo.populaters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.Item;
import com.example.demo.model.entities.OrderCustomer;

import jakarta.annotation.PostConstruct;


@Component
public class Populaters {
	public List<Customer> customers;
	public List<Item> items;
	public List<OrderCustomer> orders;

	@PostConstruct
	public void populate() {
		List<String> names=List.of( "Juan Pérez",
	            "María López",
	            "Carlos García",
	            "Ana Sánchez",
	            "Pedro Fernández",
	            "Lucía González",
	            "Luis Martínez",
	            "Sofía Romero",
	            "José Ramírez",
	            "Laura Torres",
	            "Miguel Díaz",
	            "Carmen Herrera",
	            "Raúl Navarro",
	            "Elena Castro",
	            "Diego Vázquez",
	            "Clara Molina",
	            "Antonio Moreno",
	            "Isabel Ortega",
	            "Francisco Rojas",
	            "Marta Serrano");
		customers=new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
				customers.add(new Customer((long)i+1, names.get(i)));
		}
		List<String> itemNames = Arrays.asList(
	            "Teléfono móvil",
	            "Portátil",
	            "Tablet",
	            "Auriculares inalámbricos",
	            "Reloj inteligente",
	            "Cámara digital",
	            "Teclado mecánico",
	            "Monitor 4K",
	            "Ratón ergonómico",
	            "Cargador portátil",
	            "Mochila para laptop",
	            "Altavoces Bluetooth",
	            "Disco duro externo",
	            "Memoria USB 64GB",
	            "Impresora multifunción",
	            "Smart TV",
	            "Consola de videojuegos",
	            "Silla ergonómica",
	            "Micrófono USB",
	            "Lámpara LED de escritorio"
	        );
		items=new ArrayList<>();
		for (int i = 0; i < itemNames.size(); i++) {
			items.add(new Item((long)i+1, itemNames.get(i), 0, i+20, i+10, new BigDecimal((i%10)*5)));
		}
		
		
	}
}

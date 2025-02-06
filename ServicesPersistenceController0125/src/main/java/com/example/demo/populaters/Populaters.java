package com.example.demo.populaters;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.example.demo.model.entities.Customer;
import com.example.demo.model.entities.Item;
import com.example.demo.model.entities.OrderCustomer;
import com.example.demo.model.entities.OrderLine;
import com.example.demo.model.repositories.CustomerRepository;
import com.example.demo.model.repositories.ItemRepository;
import com.example.demo.model.repositories.OrderCustomerRepository;

import jakarta.annotation.PostConstruct;


@Component
@ConditionalOnProperty(name="spring.jpa.hibernate.ddl-auto",havingValue = "create",matchIfMissing = false)
public class Populaters {
	private final CustomerRepository customerRepository;
	private final ItemRepository itemsRepository;
	private final OrderCustomerRepository orderCustomerRepository;

	public Populaters(CustomerRepository customerRepository, ItemRepository itemsRepository,
			OrderCustomerRepository orderCustomerRepository) {
		super();
		this.customerRepository = customerRepository;
		this.itemsRepository = itemsRepository;
		this.orderCustomerRepository = orderCustomerRepository;
	}

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
		for (int i = 0; i < names.size(); i++) {
//				this.customerRepository.save(new Customer(names.get(i)));
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
		for (int i = 0; i < itemNames.size(); i++) {
			itemsRepository.save(new Item(itemNames.get(i), 0, i+20, new BigDecimal((i%10)*5)));
		}
		 // Crear pedidos y líneas de pedido para cada cliente
		List<Item> items=itemsRepository.findAll();
        List<Customer> customers = customerRepository.findAll();
        customers.forEach(customer -> {
            List<OrderCustomer> orders = new ArrayList<>();
            for (int i = 1; i <= 5 + (customer.getId() % 6); i++) { // Entre 5 y 10 pedidos por cliente
                OrderCustomer order = new OrderCustomer(LocalDate.now().minusDays(i), customer);
                orders.add(order);

                // Crear líneas de pedido para cada pedido
                for (int j = 0; j < 2 + (i % 3); j++) { // Cada pedido tiene 2-4 líneas
                    Item item = items.get(j % items.size());
                    OrderLine line = new OrderLine(item, 1 + (j % 3), order); // Cantidad 1-3
                    order.addLine(line);
                }
            }
            orderCustomerRepository.saveAll(orders);
        });
    }
		
}

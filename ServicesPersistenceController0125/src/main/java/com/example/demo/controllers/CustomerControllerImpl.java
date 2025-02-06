package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dtos.CustomerDTO;
import com.example.demo.model.dtos.CustomerNewDTO;
import com.example.demo.model.responses.CustomerNewResponse;
import com.example.demo.services.CustomerServiceImpl;
@RestController
@RequestMapping("customers")
public class CustomerControllerImpl implements CustomerController{
	
	private final CustomerServiceImpl customerServiceImpl;

	public CustomerControllerImpl(CustomerServiceImpl customerServiceImpl) {
		super();
		this.customerServiceImpl = customerServiceImpl;
	}

	@Override
	@GetMapping("byid")
	public ResponseEntity<Optional<CustomerDTO>> getCustomer(@RequestParam Long id) {
		return customerServiceImpl.getCustomerDTO(id)
				.map(cusDTO->ResponseEntity.ok().body(Optional.of(cusDTO)))
				.orElse(ResponseEntity.badRequest().eTag("no existe").body(Optional.empty()));
	}

	//Commit:002
	@Override
	public ResponseEntity<CustomerNewResponse> addCustomerWayOne(String name, String telefono, String direccion,
			LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@PostMapping("new")
	public ResponseEntity<CustomerNewResponse> addCustomerWayTwo(@RequestBody CustomerNewDTO customer) {
		try {
			CustomerNewResponse newCustomer = customerServiceImpl.addNewCustomer(customer);
			return ResponseEntity.status(newCustomer.status()).body(newCustomer);
		}catch (Exception e) {
			return ResponseEntity.internalServerError().eTag("no te cuento na").body(null);
		}
	}

}












//Commit:001 

package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dtos.CustomerDTO;
import com.example.demo.services.CustomerService;
import com.example.demo.services.CustomerServiceImpl;
//Commit:001 
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

}












//Commit:001 

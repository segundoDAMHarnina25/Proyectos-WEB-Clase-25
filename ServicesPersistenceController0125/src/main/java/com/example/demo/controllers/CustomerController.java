package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dtos.CustomerDTO;


public interface CustomerController {
	
	//Commit:001 
	public ResponseEntity<Optional<CustomerDTO>> getCustomer(  Long id);
	//Commit:001 
//	public ResponseEntity<OrderCustomerResponse> setOrderCustomer(RequestEntity<OrderCustomerDTO> orderCustomer);
//	public ResponseEntity<OrderCustomerDTO> getOrderCustomer(Long id);
////	public ResponseEntity<OrderLineResponse> addLine(Long orderCustomerId,ItemDTO item, int quantity)
//	public ResponseEntity<OrderLineResponse> addLine(RequestEntity<NewLineDTO> newLine);

}

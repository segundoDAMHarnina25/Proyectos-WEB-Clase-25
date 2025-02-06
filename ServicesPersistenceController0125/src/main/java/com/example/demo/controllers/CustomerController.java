package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.dtos.CustomerDTO;
import com.example.demo.model.dtos.CustomerNewDTO;
import com.example.demo.model.responses.CustomerNewResponse;


public interface CustomerController {
	
	public ResponseEntity<Optional<CustomerDTO>> getCustomer(Long id);
	//Commit:002
	public ResponseEntity<CustomerNewResponse> addCustomerWayOne(String name,String telefono,String direccion,LocalDate fecha);
	public ResponseEntity<CustomerNewResponse> addCustomerWayTwo(CustomerNewDTO customer);
//	public ResponseEntity<OrderCustomerResponse> setOrderCustomer(RequestEntity<OrderCustomerDTO> orderCustomer);
//	public ResponseEntity<OrderCustomerDTO> getOrderCustomer(Long id);
////	public ResponseEntity<OrderLineResponse> addLine(Long orderCustomerId,ItemDTO item, int quantity)
//	public ResponseEntity<OrderLineResponse> addLine(RequestEntity<NewLineDTO> newLine);

}

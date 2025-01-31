package com.example.demo.controllers;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface CustomerController {
	
	public ResponseEntity<CustomerDTO> getCustomer(Long id);
	public ResponseEntity<OrderCustomerResponse> setOrderCustomer(RequestEntity<OrderCustomerDTO> orderCustomer);
	public ResponseEntity<OrderCustomerDTO> getOrderCustomer(Long id);
//	public ResponseEntity<OrderLineResponse> addLine(Long orderCustomerId,ItemDTO item, int quantity)
	public ResponseEntity<OrderLineResponse> addLine(RequestEntity<NewLineDTO> newLine);

}

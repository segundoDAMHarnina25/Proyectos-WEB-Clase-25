package com.example.demo.model.dtos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entities.Customer;
import com.example.demo.model.mapper.CustomerDTOMapper;

@SpringBootTest
class CustomerDTOTest {
	@Autowired
	CustomerDTOMapper customerDTOMapper;

	@Test
	void test() {
		CustomerDTO customerDTO=new CustomerDTO("Remigio");
		Customer mapToEntity = customerDTOMapper.mapToEntity(customerDTO);
		System.out.println(mapToEntity.toString());
		Customer customer=new Customer("Isabel");
		CustomerDTO mapToDTO = customerDTOMapper.mapToDTO(customer);
		System.out.println(mapToDTO.toString());
	}

}

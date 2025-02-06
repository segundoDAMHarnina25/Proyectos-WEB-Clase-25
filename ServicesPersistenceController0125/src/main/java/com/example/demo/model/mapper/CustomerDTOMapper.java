package com.example.demo.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.model.dtos.CustomerDTO;
import com.example.demo.model.entities.Customer;

@Mapper(componentModel = "spring") 
public interface CustomerDTOMapper {
	CustomerDTO mapToDTO(Customer customer);
	//Commit:001 
//	@Mapping(target="id",ignore=true)
//	@Mapping(target="creditCard",ignore=true)
//	Customer mapToEntity(CustomerDTO customerDTO);
	//Commit:001 

}

package com.example.demo.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.model.dtos.CustomerDTO;
import com.example.demo.model.entities.Customer;

@Mapper(componentModel = "spring") 
public interface CustomerDTOMapper {
	CustomerDTO mapToDTO(Customer customer);
	@Mapping(target="id",ignore=true)
	Customer mapToEntity(CustomerDTO customerDTO);

}

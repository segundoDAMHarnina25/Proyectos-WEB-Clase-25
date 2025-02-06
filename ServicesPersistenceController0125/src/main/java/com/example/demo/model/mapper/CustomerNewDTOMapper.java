package com.example.demo.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.model.dtos.CustomerNewDTO;
import com.example.demo.model.entities.Customer;

//Commit:002
@Mapper(componentModel = "spring") 
public interface CustomerNewDTOMapper {
	@Mapping(target="id",ignore=true)
	@Mapping(target="creditCard",ignore=true)
	Customer mapToEntity(CustomerNewDTO customerDTO);
}

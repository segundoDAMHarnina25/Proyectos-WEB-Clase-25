package com.example.demo.modelo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaDTO;

@Mapper(componentModel = "spring")
public interface PersonaDTOMapper {
	PersonaDTO mapToDTO(Persona persona);
	@Mapping(target="id",ignore=true)
	@Mapping(target="nacimiento",ignore=true)
	@Mapping(target="creditCard",ignore=true)
	Persona mapToEntity(PersonaDTO personaDTO);
}

package com.example.demo.modelo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonaDTOMapper {
	
	PersonaDTO mapToDTO(Persona persona);
	@Mapping(target = "id",ignore = true)
	@Mapping(target = "nacimiento",ignore = true)
	@Mapping(target = "creditCard",ignore = true)
	Persona mapToEntity(PersonaDTO personaDTO);
}

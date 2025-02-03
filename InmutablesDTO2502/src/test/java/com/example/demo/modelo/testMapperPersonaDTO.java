package com.example.demo.modelo;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class testMapperPersonaDTO {

	@Autowired
	PersonaDTOMapper personaDTOMapper;
	
	@Test
	void test() {
		Persona persona=new Persona("Aitor", LocalDate.now(), "0989-0987-6754-45634");
		PersonaDTO mapToDTO = personaDTOMapper.mapToDTO(persona);
		PersonaDTO personaDTO = new PersonaDTO("Julio", 2);
		Persona mapToEntity = personaDTOMapper.mapToEntity(personaDTO);
		System.out.println(mapToDTO.toString());
		System.out.println(mapToEntity.toString());
	}

}

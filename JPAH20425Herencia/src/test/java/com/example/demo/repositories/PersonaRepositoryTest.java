package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Persona;

@SpringBootTest
class PersonaRepositoryTest {

	@Autowired
	PersonaRepository personaRepository;
	
	@Test
	void test() {
		Persona persona = new Persona("Joaquin","Sabina");
		personaRepository.save(persona);
		//Para sacar de la bbdd necesita el constructor vacio
		assertNotNull(personaRepository.findById(persona.getId()));
	}

}

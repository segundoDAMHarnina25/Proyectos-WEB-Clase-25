package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Contrato;
import com.example.demo.modelo.Persona;

@SpringBootTest
class ContratoRepositoryTest {

	@Autowired
	ContratoRepository contratoRepository;
	@Autowired
	PersonaRepository personaRepository;
	
	@Test
	void test() {
		Persona persona = new Persona("Joaquin","Sabina");
		personaRepository.save(persona);
		persona = new Persona("Joaquin","Sabina");
		personaRepository.save(persona);
		Contrato contrato=new Contrato("bueno", persona);
		contratoRepository.save(contrato);
		assertNotNull(contratoRepository.findById(contrato.getId()));
	}

}

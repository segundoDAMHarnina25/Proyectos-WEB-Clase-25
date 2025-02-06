package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.entities.Persona;
import com.example.demo.modelo.repositories.PersonaRepository;

@SpringBootTest
class ConsultasRepositorio02ApplicationTests {

	@Autowired
	PersonaRepository personaRepository;

	@Test
	void contextLoads() {
		int edad=99;
		List<Persona> all = personaRepository.findAll();
		int size = all.size();
		List<Persona> allByEdadLessThan = personaRepository.findAllByEdadLessThanEqual(edad);
		int size2 = allByEdadLessThan.size();
		assertEquals(all.size(), personaRepository.findmayorcetes(edad).size()+size2);
	}

}

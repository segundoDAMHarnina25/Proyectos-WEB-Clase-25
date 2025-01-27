package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.singleTable.Persona;
import com.example.demo.modelo.singleTable.Piloto;
import com.example.demo.modelo.singleTable.Tripulante;

@SpringBootTest
class PilotoRepositoryTest {
	@Autowired
	PilotoRepository pilotoRepository;
	@Autowired
//	TripulanteRepository tripulanteRepository;
	PersonaRepository personaRepository;
	@Test
	void testSave() {
		Piloto piloto=new Piloto("Norberto", "mala", false);
		pilotoRepository.save(piloto);
		Persona tripulante = personaRepository.findById(piloto.getId()).get();
		System.out.println(tripulante.toString());
	}

}

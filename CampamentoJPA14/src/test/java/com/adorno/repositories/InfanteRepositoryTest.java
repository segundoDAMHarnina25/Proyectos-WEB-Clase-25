package com.adorno.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Infante;

@SpringBootTest
class InfanteRepositoryTest {
	@Autowired
	InfanteRepository infanteRepository;

	@Test
	void testFindInfantesFromActividad() {
		List<Infante> infantesFromActividad = infanteRepository.findInfantesFromActividad(8l);
		assertEquals(infanteRepository.findAll().size(),infantesFromActividad.size());
	}

}

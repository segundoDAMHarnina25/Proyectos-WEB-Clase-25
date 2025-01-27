package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.singleTable.Viajero;

@SpringBootTest
class ViajeroRepositoryTest {
	@Autowired
	ViajeroRepository viajeroRepository;

	@Test
	void testSave() {
		Viajero viajero=new Viajero("Esteban", LocalDate.now().minusDays(1));
		Viajero viajero2=new Viajero("Esteban", LocalDate.now().plus(1,ChronoUnit.DAYS));
		viajeroRepository.save(viajero);
	}

}

package com.example.demo.modelo;

import org.junit.jupiter.api.Test;

class PersonaDTOTest {

	@Test
	void test() {
		PersonaDTO personaDTO=new PersonaDTO("Esteban", 1);
		System.out.println(personaDTO.nombre());
	}

}

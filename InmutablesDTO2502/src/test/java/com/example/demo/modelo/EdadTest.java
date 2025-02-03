package com.example.demo.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EdadTest {

	@Test
	void testEdad() {
		Edad edad=new Edad(145);
	}

	@Test
	void testSetEdad() {
		Edad edad=new Edad(19);
		edad.setEdad(8);
	}

}

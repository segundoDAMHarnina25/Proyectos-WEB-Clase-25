package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.modelo.Abonado;
import com.example.demo.modelo.Miembro;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.Socio;

class PersonaTest {

	@Test
	void test() {
		Persona persona=new Persona("1","Arturo",(byte)12);
		Abonado abonado=Abonado.builder().dni("2").build();
		Socio socio=new Socio("3","Luis");
		Miembro miembro=new Miembro("5","Carlos",(byte) 43);
//		miembro.setEdad();
	}

}

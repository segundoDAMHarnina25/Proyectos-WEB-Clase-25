package com.example.demo.modelo;

public class PersonaDTO2Persona {

	public Persona mapper(PersonaDTO persona) {
		return new Persona(persona.nombre());
	}

}

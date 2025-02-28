package com.example.demo.modelo;

public class Persona2PersonaDTO {

	public PersonaDTO mapper(Persona persona) {
		return new PersonaDTO(persona.getNombre());
	}

}

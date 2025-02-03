package com.example.demo.modelo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonaResponseDTOClass {
	private final String nombre;
	private final int edad;

	public PersonaResponseDTOClass(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

}

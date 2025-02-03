package com.example.demo.modelo;

import jakarta.persistence.Embeddable;

//VO usado como envoltorio de propiedades no como su uso planteado
@Embeddable
public class Edad {
	private int edad;
	
	
	public Edad(int edad) {
		super();
		setEdad(edad);
	}

	public void setEdad(int edad) {
		if(edad>89||edad<18) throw new IllegalArgumentException("edad no valida");
		this.edad=edad;
	}

	public int getEdad() {
		return edad;
	}
	
}

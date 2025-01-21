package com.example.demo.modelo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Cancion {
	private String nombreC;
	private int duracion;
	public Cancion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cancion(String nombre) {
		super();
		this.nombreC = nombre;
	}
}

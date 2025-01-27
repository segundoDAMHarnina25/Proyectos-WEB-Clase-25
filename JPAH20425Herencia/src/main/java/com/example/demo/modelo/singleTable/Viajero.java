package com.example.demo.modelo.singleTable;

import java.time.LocalDate;

import jakarta.persistence.Entity;
@Entity
public class Viajero extends Persona {
	private LocalDate fechaAlta;

		public Viajero(String nombre, LocalDate fechaAlta) {
		super(nombre);
		this.fechaAlta = fechaAlta;
	}

}

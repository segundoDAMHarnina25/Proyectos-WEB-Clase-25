package com.example.demo.modelo;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nombre;
	private LocalDate nacimiento;
	private int edad;
	private String creditCard;

	
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
	}


	public Persona(String nombre, LocalDate nacimiento, String creditCard) {
		super();
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.creditCard = creditCard;
	}

	public int getEdad() {
		return Period.between(nacimiento, LocalDate.now()).getYears();
	}
}

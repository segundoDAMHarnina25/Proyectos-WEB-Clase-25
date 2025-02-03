package com.example.demo.modelo;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String nombre;
	private int edad;
	@NonNull
	private LocalDate nacimiento;
	@NonNull
	private String creditCard;

	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad=edad;
	}


	
}

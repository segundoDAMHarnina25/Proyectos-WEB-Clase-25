package com.example.demo.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//Este anotacion no permite enviar al json (al parsear) esta propiedad
	@JsonIgnore
	private Long id;
	private String nombre;
	@JsonIgnore
	private LocalDate nacimiento;
	// no permite que la propiedad se propague a la persistencia
	@Transient
	private int edad;
	@JsonIgnore
	private String creditCard;
}

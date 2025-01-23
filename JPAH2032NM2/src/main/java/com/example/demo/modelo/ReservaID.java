package com.example.demo.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Creando una clave compuesta
public class ReservaID implements Serializable  {
	private static final long serialVersionUID = 1L;
	private LocalDate fecha;
	private Persona persona;
	private Hotel hotel;
}

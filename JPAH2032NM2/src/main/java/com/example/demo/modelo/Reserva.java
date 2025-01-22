package com.example.demo.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Reserva implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private LocalDate fecha;
	@ManyToOne
	@NonNull
	private Persona persona;
	@ManyToOne
	@NonNull
	private Hotel hotel;
	
}

package com.example.demo.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@IdClass(ReservaID.class)
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private LocalDate fecha;
	@Id
	@ManyToOne
	private Persona persona;
	@Id
	@ManyToOne
	private Hotel hotel;
	
}

package com.example.demo.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	public LocalDate localDate;
	public double amount;
	@ManyToOne
	private Persona persona;
	@Column(unique = true)
	int numeroUnico;

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(LocalDate localDate, double amount, Persona persona, int numeroUnico) {
		super();
		this.localDate = localDate;
		this.amount = amount;
		this.persona = persona;
		this.numeroUnico = numeroUnico;
	}

}

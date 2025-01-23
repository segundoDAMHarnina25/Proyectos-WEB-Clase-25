package com.example.demo.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class StockRoom {
	/*
	 * El problema radica en que un item puede ser almacenado en cantidad variable
	 * en varios almacenes, de la misma que un almacen puede contener muchos items
	 * en cantidad variable
	 * 
	 * Esto me servira par que un servicio me pueda decir el total de un  item concreto
	 * en todos los almacenes
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
}

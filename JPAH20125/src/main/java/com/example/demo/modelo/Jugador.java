package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String apodo;

}

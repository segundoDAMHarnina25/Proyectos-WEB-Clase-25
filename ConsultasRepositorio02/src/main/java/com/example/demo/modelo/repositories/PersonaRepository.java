package com.example.demo.modelo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	//Encontrar las personas mayores de una edad
	//personas con un nombre concreto(sin apellidos)
	//por numero de socio
	/*
	 * menores de una edad y cuyo nombre empiece por X
	 * la anterior pero ordenados por edad
	 * El primero cuyo apellidos termine por x
	 * encontrar los 11 primeros cuyo apellido termina con x
	 */
}

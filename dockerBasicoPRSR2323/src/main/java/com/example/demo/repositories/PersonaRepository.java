package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	public List<Persona> findAll();

	public Persona findByNombre(String nombre);
}

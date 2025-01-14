package com.example.demo.repositorios;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Persona;

public interface PersonaRepository {
	public boolean save(Persona persona);
	public boolean delete(Persona persona);
	public Optional<Persona> findByDNI(String DNI);
	public List<Persona> findAll();
}

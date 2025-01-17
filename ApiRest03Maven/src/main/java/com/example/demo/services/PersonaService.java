package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Persona;

public interface PersonaService {
	public boolean add(Persona persona);

	public boolean delete(String DNI);
	
	public Optional<Persona> getByDNI(String DNI);

	public List<Persona> getAll();

	public boolean update(String dni, Persona persona);

	public boolean change(String dni, Persona persona);
}

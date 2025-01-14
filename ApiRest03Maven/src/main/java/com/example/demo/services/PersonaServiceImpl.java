package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Persona;
import com.example.demo.repositorios.PersonaRepository;
import com.example.demo.repositorios.PersonaRepositoryMasFalseQueJudas;

public class PersonaServiceImpl implements PersonaService {

	PersonaRepository personaRepository;

	public PersonaServiceImpl() {
		super();
		personaRepository = new PersonaRepositoryMasFalseQueJudas();
	}

	@Override
	public boolean add(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public boolean delete(String DNI) {
		Optional<Persona> byDNI = getByDNI(DNI);
		if (byDNI.isPresent())
			return personaRepository.delete(byDNI.get());
		return false;
	}

	@Override
	public Optional<Persona> getByDNI(String DNI) {
		return personaRepository.findByDNI(DNI);
	}

	@Override
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}

}

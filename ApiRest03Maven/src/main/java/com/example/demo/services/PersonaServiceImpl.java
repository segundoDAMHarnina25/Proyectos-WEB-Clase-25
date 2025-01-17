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

	/*
	 * update, por convenio, sustituye los valores de un objeto por otros
	 */
	@Override
	public boolean update(String dni, Persona persona) {
		// clausula de guarda
		if (!dni.equals(persona.getDni()))
			return false;
		return getByDNI(dni).map(person -> {
			personaRepository.delete(person);
			personaRepository.save(persona);
			return true;
		}).orElse(false);
	}

	@Override
	public boolean change(String dni, Persona persona) {
		// clausula de guarda
		if (!dni.equals(persona.getDni()))	return false;
		return getByDNI(dni).map(person -> {
			
			applyChanges(person,persona);
			
			return true;
		}).orElse(false);
	}

	private void applyChanges(Persona person, Persona persona) {
		if(persona.getNombre()!=null) person.setNombre(persona.getNombre());
		if(Integer.valueOf(persona.getEdad())!=null) person.setEdad(persona.getEdad());
	}

}

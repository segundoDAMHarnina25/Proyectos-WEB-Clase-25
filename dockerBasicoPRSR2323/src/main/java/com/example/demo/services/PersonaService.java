package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Persona;
import com.example.demo.modelo.Persona2PersonaDTO;
import com.example.demo.modelo.PersonaDTO;
import com.example.demo.modelo.PersonaDTO2Persona;
import com.example.demo.repositories.PersonaRepository;

@Service
public class PersonaService {

	private final PersonaRepository personaRepository;
	
	
	public PersonaService(PersonaRepository personaRepository) {
		super();
		this.personaRepository = personaRepository;
	}


	public Optional<List<Persona>> getAll() {
		return Optional.of(personaRepository.findAll());
	}


	public Optional<PersonaDTO> addOne(PersonaDTO persona) {
		Persona save = personaRepository.save(new PersonaDTO2Persona().mapper(persona));
		return  Optional.of(new Persona2PersonaDTO().mapper(save));
	}


	public Optional<PersonaDTO> getByName(String nombre) {
		return Optional.of(new Persona2PersonaDTO().mapper(personaRepository.findByNombre(nombre))); 
	}

}

package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.repositories.PersonaRepository;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
}

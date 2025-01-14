package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Persona;
import com.example.demo.services.PersonaService;
import com.example.demo.services.PersonaServiceImpl;


@RestController
@RequestMapping("personas")
public class PersonaController {
	PersonaService personaService;
	
	
	public PersonaController() {
		super();
		personaService=new PersonaServiceImpl();
	}

	@GetMapping("porDni")
	public Optional<Persona> getMethodName(@RequestParam String dni) {
		return personaService.getByDNI(dni);
	}
	

	@PostMapping("insercion")
	public boolean insertar(@RequestBody Persona persona) {
		return personaService.add(persona);
	}
	
	@GetMapping("all")
	public List<Persona> getAll(){
		return personaService.getAll();
	}

}

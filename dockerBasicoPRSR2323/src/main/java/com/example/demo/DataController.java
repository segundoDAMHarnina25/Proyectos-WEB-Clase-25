package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.OptionalMapperResponse;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaDTO;
import com.example.demo.services.PersonaService;

@RestController
@RequestMapping("personas")
public class DataController {

	private final PersonaService personaService;

	public DataController(PersonaService personaService) {
		super();
		this.personaService = personaService;
	}

	@GetMapping("all")
	public ResponseEntity<List<Persona>> getAll() {
		return new OptionalMapperResponse<List<Persona>>().mapper(personaService.getAll());
	}

	@PostMapping("nueva")
	public ResponseEntity<PersonaDTO> addPersona(@RequestBody PersonaDTO persona) {
		return new OptionalMapperResponse<PersonaDTO>().mapper(personaService.addOne(persona));
	}

	@GetMapping("nombre")
	public ResponseEntity<PersonaDTO> getPersonaByName(@RequestParam String nombre) {
		return new OptionalMapperResponse<PersonaDTO>().mapper(personaService.getByName(nombre));
	}

}

package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mappers.RequestUpdatePersona;
import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaDTO;
import com.example.demo.modelo.PersonaResumenDTO;
import com.example.demo.modelo.Response;
import com.example.demo.services.PersonaService;

@RestController
@RequestMapping("personal")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@GetMapping("porid")
	public ResponseEntity<PersonaResumenDTO> getPersonaResumen(@RequestParam int id) {
		try{
			Optional<PersonaResumenDTO> personaResumenById = personaService.findPersonaResumenById(id);
			if (personaResumenById.isPresent())
				return ResponseEntity.ok(personaResumenById.get());
			return (ResponseEntity<PersonaResumenDTO>) ResponseEntity.badRequest();
		}catch (Exception e) {
			return ResponseEntity.ok(null);
		}
	}

	@GetMapping("personas")
	public ResponseEntity<Response> personas() {
		return ResponseEntity.ok(Response.builder().TimeStamp(LocalDateTime.now()).Message("personas recuperados")
				.Status(HttpStatus.OK).Data(Map.of("personas", personaService.getPersonas())).build());
	}

	@GetMapping("personasaa")
	public ResponseEntity<Response> gpersonas() {
		// son dos forma de hacerlo
		ResponseEntity.status(null).eTag(null).build();
		return ResponseEntity.ok().body(null);
	}

	@GetMapping("personasa")
	public ResponseEntity<Response> personasa() {
		return
//				ResponseEntity.ok(
//						Response.builder()
//						.TimeStamp(LocalDateTime.now())
//						.Message("personas recuperados")
//						.Status(HttpStatus.OK)
//						.Data(Map.of("personas",personaService.getPersonas()))
//						.build()
//				);
//				ResponseEntity.status(5).
		ResponseEntity.badRequest().body((Response) new Response());
	}

	@GetMapping("cosas")
	public ResponseEntity<Boolean> cosas(@RequestBody RequestEntity<Persona> cosa) {
		Persona body = cosa.getBody();
		// haz lo que sea con body y luego responde como quieras
		return ResponseEntity.ok(true);
	}

	@GetMapping("cosas2/{cosa}")
	public ResponseEntity<Boolean> cosas2(@PathVariable String cosa) {
		System.out.println("lo que viene " + cosa);
		return ResponseEntity.ok(true);
	}

	@GetMapping("peticion/{inicial}")
	public List<Persona> busca(@PathVariable("inicial") String inicial) {
		return personaService.getPersonas().stream().filter((Persona per) -> per.getNombre().startsWith(inicial))
				.collect(Collectors.toList());
	}

	@GetMapping("personasIN")
	public List<Persona> buscaIN(@RequestParam String inicial) {
		return personaService.getPersonas().stream().filter((Persona per) -> per.getNombre().startsWith(inicial))
				.collect(Collectors.toList());
	}

	// Una operacion de POST se entiende que es para llevar nueva informacion al
	// servidor
	@PostMapping("PersonaNew")
	public boolean addNewPerson(@RequestBody Persona persona) {
		return personaService.addPersona(persona);
	}

	// Una operacion PUT y que se suele utilizar para actualizar datos existentes
	@PutMapping("actualizar")
	public boolean updatePerson(@RequestParam int id, @RequestBody RequestUpdatePersona persona) {
		return personaService.update(id, persona);
	}

	// Operacion de borrado DELETE
	@DeleteMapping("delete")
	public boolean deletePerson(@RequestParam int id) {
		return personaService.delete(id);
	}

}

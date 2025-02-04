package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("socios")
public class SocioController {

	@PostMapping("nuevo")
	public boolean add(@Valid @RequestBody Socio entity) {
		Socio otro = new Socio(entity.getId(), entity.getNombre(), entity.getEdad());
		return true;
	}

	@GetMapping("/aviso")
	public String avisar() {
		return "esta funciona";
	}
}

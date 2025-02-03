package com.example.demo;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Socio;

@RestController
@RequestMapping("socios")
public class SocioController {

	@GetMapping("uno")
	public ResponseEntity<Socio> getSocio(){
		return ResponseEntity.ok(new Socio(2l, "Ataulfo", LocalDate.now(), 5, "banco"));
	}
}

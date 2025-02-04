package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("socios")
public class SocioController {
	private final SocioService socioService;
	

	public SocioController(SocioService socioService) {
		super();
		this.socioService = socioService;
	}

	@PostMapping("nuevo")
	public boolean add(@Valid @RequestBody Socio entity) {
		try {
		socioService.add(entity);
		}catch (Exception e) {
			System.out.println("fallo en la validacion");
		}
		return true;
	}

	@GetMapping("aviso")
	public String avisar() {
		return "esta funciona";
	}
}

package com.adorno.mvcIMoustache.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adorno.mvcIMoustache.services.ColorsService;
import com.adorno.mvcIMoustache.services.NamingService;

@Controller
public class SaludoController {

	private final NamingService namingService;

	@Autowired
	private ColorsService colorsService;

	public SaludoController(NamingService namingService) {
		super();
		this.namingService = namingService;
	}

	// El primer endpoint
	// donde especifico la ruta del cliente
	@RequestMapping("saludo")
	public String darAlgo() {
		return "saludorespuesta";
	}

	@RequestMapping("resaludo")
	public String darOtro(Model model) {
		model.addAttribute("name", namingService.getRandomName());
		model.addAttribute("silent", true);
		return "resaludoRespuesta";
	}

	@RequestMapping("colorear")
	public String coloreando(Model model) {
		model.addAttribute("colors", colorsService.getColors());
		return "colorsRespuesta";
	}
}

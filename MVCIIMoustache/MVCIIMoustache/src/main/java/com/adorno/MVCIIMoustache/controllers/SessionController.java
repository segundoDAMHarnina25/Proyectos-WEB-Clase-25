package com.adorno.MVCIIMoustache.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

	
	//primer endpoint
	@RequestMapping("dimeAlgo")
	public String giveMe(@RequestParam String param,Model model) {
		model.addAttribute("parametro",param);
		return "saySomething";
	}
	
	//segundoEndpoint
	@RequestMapping(value = "procesarFormulario", method = RequestMethod.POST)
	public String procesarFormulario(@RequestParam String info,HttpSession session) {
		session.setAttribute("infoUsuario",info);
		return "resultado_formulario";
	}
	
	@RequestMapping("mostrarDatos")
	public String mostrarDatos(Model model, HttpSession sesion) {
		model.addAttribute("infoUsuario",sesion.getAttribute("infoUsuario"));
		return "datos";
	}
}

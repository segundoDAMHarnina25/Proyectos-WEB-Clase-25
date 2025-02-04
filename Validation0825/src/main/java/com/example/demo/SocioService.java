package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SocioService {
	private final NombreSimpleVerifier nombreSimpleVerifier;
	
	public SocioService(NombreSimpleVerifier nombreSimpleVerifier) {
		super();
		this.nombreSimpleVerifier = nombreSimpleVerifier;
	}

	//Prueba priero sin lanzar excepcion
	public boolean add(Socio socio) throws Exception {
		//Donde se pasa la validacion
		if(!nombreSimpleVerifier.verify(socio.getNombre())) throw new Exception("nombre con espacio");
		//este retorno deberia depender del repo
		return false;
	}
}

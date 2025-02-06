package com.example.demo.mappers;

import com.example.demo.modelo.Persona;
import com.example.demo.modelo.PersonaResumenDTO;

//Como crear este elemento
public class PersonaResumenDTOMapper implements MyMapper<PersonaResumenDTO,Persona>{

	@Override
	public PersonaResumenDTO map(Persona s) {
		return new PersonaResumenDTO(s.getNombre(), s.getEdad());
	}

}

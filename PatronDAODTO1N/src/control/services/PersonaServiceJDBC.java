package control.services;

import modelo.abstractDAO.ContratoDAO;
import modelo.abstractDAO.PersonaDAO;
import modelo.entity.Persona;

public class PersonaServiceJDBC implements PersonaService{

	PersonaDAO personaDAO;
	ContratoDAO contratoDAO;
	@Override
	public Persona findPersonaByContrato(Long idContrato) {
		return personaDAO.findById(contratoDAO.findPersonaIdByContrato(idContrato));
	}

}

package modelo.abstractDAO;

import modelo.entity.Contrato;
import modelo.entity.Persona;

public interface ContratoDAO extends GenericDAO<Contrato, Long> {
	//intenta desarrollar esto y explica los problemas que le ves
	public Persona findPersonaByContrato(Long idContrato);
}

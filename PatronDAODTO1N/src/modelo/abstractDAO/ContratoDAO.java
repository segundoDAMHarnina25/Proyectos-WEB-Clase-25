package modelo.abstractDAO;

import modelo.entity.Contrato;

public interface ContratoDAO extends GenericDAO<Contrato, Long> {
	//intenta desarrollar esto y explica los problemas que le ves
	public Long findPersonaIdByContrato(Long idContrato);
}

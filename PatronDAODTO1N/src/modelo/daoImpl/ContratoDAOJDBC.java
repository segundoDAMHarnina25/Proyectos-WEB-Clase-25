package modelo.daoImpl;

import java.util.Collection;

import modelo.abstractDAO.ContratoDAO;
import modelo.abstractDAO.PersonaDAO;
import modelo.entity.Contrato;
import modelo.entity.Persona;

public class ContratoDAOJDBC implements ContratoDAO {
	
	@Override
	public void create(Contrato entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Contrato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contrato findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findPersonaIdByContrato(Long idContrato) {
		return findById(idContrato).getPersonaID();
	}

}

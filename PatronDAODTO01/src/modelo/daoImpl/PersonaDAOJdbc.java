package modelo.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import mapper.PersonaMapper;
import modelo.abstractDAO.PersonaDAO;
import modelo.acceso.AccessJdbc;
import modelo.entity.Persona;

public class PersonaDAOJdbc implements PersonaDAO {

	private AccessJdbc accessJdbc;

	public PersonaDAOJdbc(AccessJdbc accessJdbc) {
		super();
		this.accessJdbc = accessJdbc;
	}

	@Override
	public void create(Persona entidad) {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Persona> findAll() {
		ResultSet conjuntoResultados = accessJdbc.execute("SELECT * FROM persona");
		Collection<Persona> personas = new ArrayList<>();
		try {
			while (conjuntoResultados.next()) {
				personas.add(new PersonaMapper().map(conjuntoResultados));
			} 
		} catch (Exception e) {
			return null;
		}
		return personas;
	}

	@Override
	public Persona findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

package modelo.ImplDAOJDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;

import mapper.PersonaAdapter;
import mapper.PersonaMapper;
import modelo.AbstractDAO.PersonaDAO;
import modelo.Entity.Persona;
import modelo.acceso.AccessJdbc;

public class PersonaDAOJdbc implements PersonaDAO {

	private AccessJdbc accessJdbc;

	public PersonaDAOJdbc(AccessJdbc accessJdbc) {
		super();
		this.accessJdbc = accessJdbc;
	}

	@Override
	public void create(Persona entidad) {
		String sql = "INSERT INTO ejemplo.persona  (nombre, apellidos,alta) VALUES ( ?, ?, ?)";
		accessJdbc.update(sql,new PersonaAdapter(entidad));
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
	public Persona findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Persona findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

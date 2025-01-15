package modelo.abstractDAO;

import modelo.entity.Persona;

public interface PersonaDAO extends GenericDAO<Persona, Long> {
	public Persona findByName(String name);
}

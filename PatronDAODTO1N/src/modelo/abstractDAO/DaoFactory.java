package modelo.abstractDAO;

public abstract class DaoFactory {
	public DaoFactory factory;

	public DaoFactory() {
		super();
	}

	public DaoFactory getFactory() {
		return factory;
	}

	public void setFactory(DaoFactory factory) {
		this.factory = factory;
	}
	
	public abstract PersonaDAO getPersonaDAO();
	
}

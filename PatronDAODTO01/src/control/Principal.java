package control;

import java.sql.SQLException;
import java.util.Collection;

import modelo.abstractDAO.DaoFactory;
import modelo.abstractDAO.PersonaDAO;
import modelo.daoImpl.DAOFactoryJDBC;
import modelo.entity.Persona;

public class Principal {

	public static void main(String[] args) {
		try {			
			DaoFactory daoFactory=new DAOFactoryJDBC();
			PersonaDAO personaDAO=daoFactory.getPersonaDAO();
			Collection<Persona> findAll = personaDAO.findAll();
			findAll.stream().forEach((a)->{System.out.println(a);});
			System.out.println("acabe");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

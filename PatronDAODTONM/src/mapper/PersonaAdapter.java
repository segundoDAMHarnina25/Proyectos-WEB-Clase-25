package mapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

import modelo.Entity.Persona;

public class PersonaAdapter implements Adapter {
	private Persona persona;

	public PersonaAdapter(Persona persona) {
		super();
		this.persona = persona;
	}

	@Override
	public void adapt(PreparedStatement declaracion) throws SQLException {
		// Establecer los valores de los par�metros en la sentencia SQL
		declaracion.setString(1, persona.getNombre());
		declaracion.setDate(3,Date.valueOf(LocalDate.now()));

		// Ejecutar la sentencia SQL
		declaracion.executeUpdate();
	}
}

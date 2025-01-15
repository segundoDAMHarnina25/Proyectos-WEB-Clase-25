package mapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		declaracion.setString(2, "Salasar con s");
		Calendar calendario = Calendar.getInstance();
        // Obtiene la fecha y hora actual
        Date fechaActual = new Date(calendario.getTime().getTime());
		declaracion.setDate(3, fechaActual);

		// Ejecutar la sentencia SQL
		declaracion.executeUpdate();
	}
}

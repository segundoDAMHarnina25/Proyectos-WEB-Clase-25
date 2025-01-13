import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	public static void main(String[] args) {
		String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
		String URL_BASEDATOS = "jdbc:mysql://localhost:3307/ejemplo";
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL_BASEDATOS, "harnina", "zzzz");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet conjuntoResultados = null;
		Statement instruccion = null;
		try {
			instruccion = conexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM persona");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("con consulta");
		ResultSetMetaData metaDatos = null;
		try {
			metaDatos = conjuntoResultados.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int numeroDeColumnas = 0;
		try {
			numeroDeColumnas = metaDatos.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= numeroDeColumnas; i++)
			try {
				System.out.printf("%-8s\t", metaDatos.getColumnName(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		try {
			System.out.println();
			while (conjuntoResultados.next()) {
				for (int i = 1; i <= numeroDeColumnas; i++)
					System.out.printf("%-8s\t", conjuntoResultados.getObject(i));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

/*
 * Revisado para versión 8.19 de MySQL 
 * Alberto Carrera Martín
 * 29 febrero 2020
 */
package Ejercicio2;

import java.sql.*;
import java.util.ArrayList;

public class AccesoBdatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String database = "sample";
	private static String hostname = "localhost";
	private static String port = "3309";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database
			+ "?serverTimezone=Europe/Madrid";
	private static String username = "root";
	private static String password = "root";
	static ResultSet reg;

// NUNCA CONECTARSE CON USUARIO ROOT!!!!!!!!!!!!!!!!!!!
// SOLO PARA PRUEBAS!!!!!!!

	public Connection conecta;

	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}

	public ArrayList<Usuario> consultarTodos() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		try {
			Statement consulta = conecta.createStatement();
			ResultSet reg = consulta.executeQuery("SELECT * FROM usuario");
			while (reg.next()) {
				Usuario user = new Usuario(reg.getString(1), reg.getInt(2), reg.getString(3));
				lista.add(user);
			}
			consulta.close();
		} catch (SQLException e) {
			return null;
		}
		return lista;
	}

	public String compruebaContraseña(String usu, String pass) throws SQLException {
		Statement consulta = conecta.createStatement();
		 reg = consulta.executeQuery("select * from usuario where username = '" + usu + "' and password='" + pass + "'");
		if (reg.next())
			return reg.getNString(3);
		else
			return "El usuario/contraseña es incorrecto.";

	}

	//

	//
	public void desconectar() throws SQLException {
		if (conecta != null) {
			conecta.close();
		}
	}
}
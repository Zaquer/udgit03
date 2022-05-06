/*
 * Revisado para versión 8.19 de MySQL 
 * Alberto Carrera Martín
 * 29 febrero 2020
 */
package Ejercicio3v3;
import java.sql.*;
import java.util.ArrayList;

import Ejercicio1.Socio;
public class AccesoBdatos {
private static String driver = "com.mysql.cj.jdbc.Driver";
private static String database = "baloncesto";
private static String hostname = "localhost";
private static String port = "3309";
private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?serverTimezone=Europe/Madrid";
private static String username = "root";
private static String password = "root";

// NUNCA CONECTARSE CON USUARIO ROOT!!!!!!!!!!!!!!!!!!!
// SOLO PARA PRUEBAS!!!!!!!

public Connection conecta;

	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}
	
	public ArrayList <Socio> consultarTodos(){
		ArrayList <Socio>lista = new ArrayList<Socio> ();
	
		try {
			Statement consulta = conecta.createStatement();
			ResultSet reg = consulta.executeQuery ("SELECT * FROM socio");
			while (reg.next ()) {
				Socio socio= new Socio(reg.getInt(1),reg.getString(2),reg.getInt(3),reg.getInt(4),reg.getString(5));
				lista.add(socio);
		}
		consulta.close ();
		} catch (SQLException e) {
			return null;
		} 
		return lista;
		}
	
	public ArrayList <Socio> consultarPorLocalidad(String Localidad){
		ArrayList <Socio>lista = new ArrayList<Socio> ();
		try {
			Statement consulta = conecta.createStatement();
			ResultSet reg = consulta.executeQuery ("SELECT * FROM socio WHERE localidad LIKE '%" + Localidad+"%'");
			
			while (reg.next ()) {
				Socio socio= new Socio(reg.getInt(1),reg.getString(2),reg.getInt(3),reg.getInt(4),reg.getString(5));
				lista.add(socio);
		}
		consulta.close ();
		return lista;
		}
		catch (SQLException e) {
			System.out.println("error en la consulta"+e.getMessage());
		return null;
		}
		} //consultarporLocalidad
        //
	
	public ResultSet consultarPorLocalidadResultSet(String Localidad) throws SQLException{
		PreparedStatement consulta = conecta.prepareStatement("SELECT * FROM socio WHERE localidad LIKE=?");
		consulta.setString(1,Localidad);
		ResultSet reg = consulta.executeQuery();
		
		return reg;
		
	}
	
	public ResultSet consultarTodosResultSetSocios() throws SQLException{
		PreparedStatement consulta = conecta.prepareStatement("SELECT * FROM socio");
		ResultSet reg = consulta.executeQuery();
		
		return reg;
	}
	
	//
	public void desconectar() throws SQLException {
		if (conecta !=null) {
			conecta.close();
		}
	}
}
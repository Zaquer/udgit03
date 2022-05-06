package ejercicios;
//// https://docs.oracle.com/en/java/javase/14/docs/api/java.sql/java/sql/DatabaseMetaData.html

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// Alberto Carrera Martín - Abril 2020


public class AccesoBdatos {

	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "empleados";
    private static String hostname = "localhost";
    private static String port = "3309";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database +
									"?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "root";

    private Connection conecta;
    private static DatabaseMetaData metadata;
	
	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
		metadata = conecta.getMetaData();
	}
	
	public void desconectar() throws SQLException, ClassNotFoundException {
		
		conecta = null; // = conecta.close();
	}
	
	public static void infoGeneralMetadata() throws SQLException {
		
		String mensaje= "Gestor de base de datos: " + metadata.getDatabaseProductName() + "\n" 
				+"Versión instalada: "+ metadata.getDatabaseProductVersion() + "\n" 
        		+ "Usuario conectado: " + metadata.getUserName() + "\n"
        		+ "Tipo de driver JDBC: " + metadata.getDriverName() + "\n"
        		+ "Versiones JDBC soportadas: " +metadata.getJDBCMinorVersion() +" a " + metadata.getJDBCMajorVersion() + "\n"
        		+ "Versión del Driver: " + metadata.getDriverVersion();

		JOptionPane.showMessageDialog(null,  mensaje, "Información del SGBD", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public  void tablasMetadata(String catalogo) throws SQLException {
		String mensaje = "";
		String [] tablaTipos = {"TABLE", "VIEW"};
		ResultSet rs = metadata.getTables(catalogo, null, null, tablaTipos);
		while (rs.next()) {
			mensaje = mensaje +  "Nombre: " +	rs.getString("TABLE_NAME") + " - "
							  + "Tipo : " + rs.getString("TABLE_TYPE") + "\n";
		}
		JOptionPane.showMessageDialog(null,  mensaje, "Tablas de la Bda " + catalogo, JOptionPane.INFORMATION_MESSAGE);
		
		
			
		
	}
	
	public  void tablasMetadataMejorado(String catalogo) throws SQLException {
		String mensaje = "";
		if (!existeCatalogo(catalogo)) {
			mensaje = " No existe el catálogo: " + catalogo;
			JOptionPane.showMessageDialog(null,  mensaje, catalogo + " no encontrado", JOptionPane.INFORMATION_MESSAGE);
			System.exit(-1);
		}
		String tablaTipos[] = {"TABLE", "VIEW"};
		ResultSet rs = metadata.getTables(catalogo, null, null, tablaTipos);
		while (rs.next()) {
			mensaje = mensaje +  "Nombre: " +	rs.getString("TABLE_NAME") + " - "
							  + "Tipo : " + rs.getString("TABLE_TYPE") + "\n";
		}
		JOptionPane.showMessageDialog(null,  mensaje, "Tablas de la Bda " + catalogo, JOptionPane.INFORMATION_MESSAGE);	
	}// comprueba si existe la bd y no esta vacia, y despues muestra las tablas y su tipo EJ-1
	
	public boolean existeCatalogo (String catalogo) throws SQLException {
		boolean encontrado = false;
		ResultSet rs = metadata.getCatalogs();
		
		while (rs.next()) {
			if (rs.getString("TABLE_CAT").equalsIgnoreCase(catalogo)){
				encontrado =true;
				break;
			}
		}
		return encontrado;
	}
	
	public void columnasMetadata(String catalogo, String tabla) throws Exception, SQLException {
		String mensaje = "";
		if (!existeCatalogo(catalogo)) {
			mensaje = " No existe la base de datos: " + catalogo + " o la tabla "+tabla;
			JOptionPane.showMessageDialog(null,  mensaje, catalogo + " no encontrado", JOptionPane.INFORMATION_MESSAGE);
			System.exit(-1);
		}
		String tablaTipos[] = {"TABLE", "VIEW"};
		ResultSet rs = metadata.getColumns(catalogo, null, tabla, null);
		ResultSet rs2 = metadata.getPrimaryKeys(catalogo, null, tabla);
		while (rs.next()) {
			mensaje = mensaje +  "Nombre: " +	rs.getString("COLUMN_NAME") + " - "
									+ "Tipo : " + rs.getString("TYPE_NAME") + " - "
									  + "Tamaño : " +rs.getString("COLUMN_SIZE")+ " - "
									  + "Admite nulos : "+rs.getString("IS_NULLABLE") +"\n";
		}
		mensaje= mensaje+ "\n----------------------------------------------------\n Clave/s primaria/s: ";
		while (rs2.next()) {
			mensaje= mensaje +" "+ rs2.getString("COLUMN_NAME");
		}
		
		JOptionPane.showMessageDialog(null,  mensaje, "Columnas de la tabla " + catalogo, JOptionPane.INFORMATION_MESSAGE);	
	}

	
}
package Ejercicios;
/*
 * Revisado para versión 8.0.19 de MySQL 
 * Alberto Carrera Martín
 * y añadido comentarios el 17 de marzo de 2020
 * 
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
public class AccesoBdatos {
	private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String database = "demodb";
    private static String hostname = "localhost";
    private static String port = "3309";
	private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database +
									"?serverTimezone=Europe/Madrid";
    private static String username = "root";
    private static String password = "root";
    private Connection conecta;
	
	public void conectar() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conecta = DriverManager.getConnection(url, username, password);
	}
	
	public void desconectar() throws SQLException, ClassNotFoundException {
		
		conecta = null; // = conecta.close();
	}
	
	public Empleado busquedaPorCodigo(int numero){
		try {
			PreparedStatement consulta = conecta.prepareStatement("SELECT * FROM emp WHERE EMPNO=?");
			consulta.setInt(1, numero);
			ResultSet reg = consulta.executeQuery ();
			Empleado empleado1 = new Empleado();

			if (reg.next ()) {
				empleado1.setEMPNO(reg.getInt (1));
				empleado1.setENAME(reg.getString(2));
				empleado1.setJOB(reg.getString(3));
				empleado1.setMGR(reg.getInt (4));
				empleado1.setHIREDATE(reg.getDate(5));
				empleado1.setSal(reg.getDouble (6));
				empleado1.setCOMM(reg.getDouble (7));
				empleado1.setDEPTNO(reg.getInt (8));
				
			}
			// si no he recuperado ninguna, devuelvo null
			else
				empleado1=null;
			consulta.close ();
			return empleado1;
		}
		catch (SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Empleado> busquedaPorOficio(String Oficio){
		ArrayList<Empleado> Empleados = new ArrayList<Empleado> ();
		try {
			PreparedStatement consulta = conecta.prepareStatement("SELECT * FROM emp where job=?");
			consulta.setString(1, Oficio);
			ResultSet reg = consulta.executeQuery ();
			while (reg.next ()) {
				Empleado Empleado1 = new Empleado(reg.getInt (1), reg.getString (2), reg.getString (3),reg.getInt (4),reg.getDate(5),reg.getDouble (6),reg.getDouble (7),reg.getInt (8));
				Empleados.add(Empleado1);
			}
			consulta.close ();
		} catch (SQLException e) {
			return null; 
		} 
			return Empleados;
		}
	
	public ArrayList<Empleado> busquedaPorAntiguedad(Date fecha){
		ArrayList<Empleado> Empleados = new ArrayList<Empleado> ();
		try {
			PreparedStatement consulta = conecta.prepareStatement("SELECT * FROM emp where HIREDATE<=?");
			consulta.setDate(1, fecha);
			ResultSet reg = consulta.executeQuery ();
			while (reg.next ()) {
				Empleado Empleado1 = new Empleado(reg.getInt (1), reg.getString (2), reg.getString (3),reg.getInt (4),reg.getDate(5),reg.getDouble (6),reg.getDouble (7),reg.getInt (8));
				Empleados.add(Empleado1);
			}
			consulta.close ();
		} catch (SQLException e) {
			return null; 
		} 
			return Empleados;
		}

	public int insertarConBean(Empleado e1) {
		try {
			String sql="insert into emp values (?,?,?,?,?,?,?,?)";
			PreparedStatement inserta =conecta.prepareStatement(sql);
			inserta.setInt(1,e1.getEMPNO());
			inserta.setString(2,e1.getENAME());
			inserta.setString(3,e1.getJOB());
			inserta.setInt(4,e1.getMGR());
			inserta.setDate(5,e1.getHIREDATE());
			inserta.setDouble(6,e1.getSal());
			inserta.setDouble(7,e1.getCOMM());
			inserta.setInt(8,e1.getDEPTNO());
			inserta.executeUpdate();
			return 1;
		} catch(SQLException e){
			return e.getErrorCode();
		}
	}
	
	public int actualizarSalario(int departamento, double porcentaje) {
		try {
		String sql="update emp set SAL=SAL+(SAL*?) where DEPTNO=?";
		PreparedStatement actualiza = conecta.prepareStatement(sql);
		actualiza.setDouble(1,porcentaje);
		actualiza.setInt(2, departamento);
		
		return (actualiza.executeUpdate());
		
	} catch(SQLException e){
		return 0;
		}
	}
	
	public int actualizarSalarioconTransacciones(int departamento, double
			porcentaje) throws SQLException {
		
		try {
		String sql="update emp set SAL=SAL+(SAL*?) where DEPTNO=?";
		conecta.setAutoCommit(false);
		PreparedStatement actualiza = conecta.prepareStatement(sql);
		actualiza.setDouble(1,porcentaje);
		actualiza.setInt(2, departamento);
		conecta.commit();
		conecta.setAutoCommit(true);// para probar el metodo, realmente habra que poner commits en todos los metodos.
		return (actualiza.executeUpdate());
		
	} catch(SQLException e){
		conecta.rollback();
		conecta.setAutoCommit(true);
		return 0;
		}
		
	}
	
	public int borrarEmpleado (int numero) {
		
		try {
			PreparedStatement baja = conecta.prepareStatement("DELETE FROM emp WHERE EMPNO=?");
			baja.setInt(1, numero);
			
			
		return (baja.executeUpdate ());
		} catch (SQLException e) {
			return e.getErrorCode(); // En caso de error en la consulta devuelve el código de error MySQL
		}
		
		
	}
	
}



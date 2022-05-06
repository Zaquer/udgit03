package Ejercicios;
import java.math.BigDecimal;
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
    private static String database = "pedidos";
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

	
	
	public void importePedido(int pedido) {
		 CallableStatement proc;
		try {
			proc = conecta.prepareCall("Select importePedido(?) ");
			 proc.setInt(1, pedido);
			 ResultSet rs=proc.executeQuery();
			 BigDecimal numero;
		       if (rs.next()) {
		    	   numero = rs.getBigDecimal(1);
		           System.out.println("El importe del pedido es "+numero);
		       }
		       else {
		    	   System.out.println("El numero de pedido no existe.");
		   	    rs.close();
			    proc.close();   
				conecta.close();
		    	
		       }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void prodCatBajoMinimos(int categoria) {
		 CallableStatement proc;
		try {
			proc = conecta.prepareCall("call productosCategoriaBajoMinimos(?) ");
			 proc.setInt(1, categoria);
			 ResultSet rs=proc.executeQuery();
	    	  String nom;
	    	  Double prec;
	    	  int und;
	    	  int Npedido;
		      if(rs.next()) {
		    	  	nom=rs.getString(1);
		    	    prec=rs.getDouble(2);
		    	    und=rs.getInt(3);
		    	    Npedido=rs.getInt(4);
		    	    System.out.println("Nombre del producto: "+nom+", Precio por unidad: "+prec+", Unidades en existencia: "+und+", Nivel nuevo producto: "+Npedido);
			 	while (rs.next()) {
		    	    nom=rs.getString(1);
		    	    prec=rs.getDouble(2);
		    	    und=rs.getInt(3);
		    	    Npedido=rs.getInt(4);
		    	    System.out.println("Nombre del producto: "+nom+", Precio por unidad: "+prec+", Unidades en existencia: "+und+", Nivel nuevo producto: "+Npedido);
		    	  }
		      }
			 	else {
		    	   System.out.println("El numero de categoria no existe.");
		   	    rs.close();
			    proc.close();   
				conecta.close();
		    	
		       }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}



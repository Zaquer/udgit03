package Ejercicio1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaSociosBaloncesto {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AccesoBdatos abd = new AccesoBdatos();
		//
		try {
			abd.conectar();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("NO SE PUDO ESTABLECER CONEXIÓN");
			System.exit(-1);
		}

		ArrayList<Socio> todosSocios = abd.consultarTodos();
		int contador = 0;
		if (todosSocios.size() != 0) {
			System.out.println("LISTA DE SOCIOS\n" + "===============");
			for (Socio l : todosSocios) {
				System.out.println(l);
				contador++;
			}
		} else
			System.out.println("Lista de todos los socios vacía");
		//
		//
		System.out.println("\n");
		//
		System.out.println("Total de socios: " + contador);

		//
		//
		System.out.println("\nLISTA POR LOCALIDAD\n====================");

		System.out.println("Escriba una localidad para consultar sus jugadores: ");
		String x = s.next();

		ArrayList<Socio> SociosLocalidad = abd.consultarPorLocalidad(x);
		contador = 0;
		if (SociosLocalidad.size() != 0) {
			for (Socio l : SociosLocalidad) {
				System.out.println(l);
				contador++;
			}
			System.out.println("Total de socios en la localidad: " + contador);
		} else {
			ArrayList<Socio> todosSocios2 = abd.consultarTodos();
			contador = 0;
			if (todosSocios2.size() != 0) {
				System.out.println("LISTA DE SOCIOS\n" + "===============");
				for (Socio l : todosSocios2) {
					System.out.println(l);
					contador++;
				}
				System.out.println("Total de socios: " + contador);
			}
		}
		System.out.println("\nLISTA POR LOCALIDAD 2\n====================");

		System.out.println("Escriba una localidad para consultar sus jugadores: ");
		x = s.next();
		
		try {
			if(x.isEmpty())
				abd.consultarTodosResultSetSocios();
			else	
				abd.consultarPorLocalidadResultSet(x);
			 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			abd.desconectar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

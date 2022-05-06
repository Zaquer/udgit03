package Ejercicios;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		AccesoBdatos abd=new AccesoBdatos();
		abd.conectar();
		Scanner s = new Scanner(System.in);
		System.out.println("Escriba el numero de pedido: ");
		int pedido=s.nextInt();
		
		abd.importePedido(pedido);
		
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		int categoria = 1;
		abd.prodCatBajoMinimos(categoria);
		
		
		
		
		
		
		
		abd.desconectar();
		
	}

}

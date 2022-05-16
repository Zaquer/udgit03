package EjerciciosParte1;

import java.util.Scanner;

public class Ejercicio06 {

	public static double cuadrado (double x) {
		double z=Math.sqrt(x);
		return z;
	}
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in)) {
			System.out.print("Por favor, introduce un entero: ");
		    int x = s.nextInt();
		    if (x%cuadrado(x)==0)
		    System.out.print("El numero  "+x+" puede ser expresado como "+cuadrado((int)x)+" al cuadrado.");
		    else 
		    System.out.print("0");
		}
	}

}

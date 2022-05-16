package EjerciciosParte1;

import java.util.Scanner;

public class Ejercicio05 {

	public static double potencia(final double a, double b) {
			double c=1;
		for (double i=1; i<=b; i++) {
			 c=(c*a);
			}return c;
	}
	public static void main(String[] args) {
		
		try (// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in)) {
			System.out.print("Introduce dos numeros: ");
			double a = s.nextDouble();double b=s.nextDouble();
			System.out.print("La potencia de  "+a+" elevado a "+b+" es "+potencia(a,b));
		}
	}
}

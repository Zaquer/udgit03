package EjerciciosParte1;

import java.util.Scanner;

public class Ejercicio02 {

	public static boolean multiplo(double m, double n) {
		boolean resultado = (n % m == 0);
		return resultado;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Introduce 2 numeros: ");
			double x = s.nextDouble();
			double y = s.nextDouble();
			boolean resultado = multiplo(x, y);
			System.out.print(resultado);
			System.exit(0);
		}
	}
}

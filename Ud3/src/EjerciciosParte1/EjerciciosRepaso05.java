package EjerciciosParte1;

import java.util.Scanner;

public class EjerciciosRepaso05 {
	static Scanner s = new Scanner(System.in);

	public static void rellenar(String[] nombres, double[] sueldos) {
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Introduzca la persona: " + i);
			nombres[i] = s.next();
			System.out.println();
			System.out.println("Introduzca el sueldo: ");
			sueldos[i] = s.nextInt();
		}
	}

	public static void main(String[] args) {
		int n = 10;
		String[] nombres = new String[n];
		double[] sueldos = new double[n];
		double max = sueldos[0];
		rellenar(nombres, sueldos);

		for (int i = 0; i < n; i++) {
			if (sueldos[i] > max) {
				max = sueldos[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (max == sueldos[i]) {
				System.out.println("El sueldo megor pagado es " + max + " euros y es " + nombres[i]);
			}
		}

	}

}

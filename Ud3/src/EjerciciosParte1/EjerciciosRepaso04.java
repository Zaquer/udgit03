package EjerciciosParte1;

import java.util.Scanner;

public class EjerciciosRepaso04 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
		double suma = 0;
		int contS = 0;
		int contI = 0;
		System.out.println("Introduce de cuantas personas quieres leer la altura:  ");
		n = s.nextInt();
		while (n < 0) {
			System.out.println("Introduce de cuantas personas quieres leer la altura:  ");
			n = s.nextInt();
		}

		double[] num = new double[n];
		System.out.println("Introduce la altura de las personas:  ");
		for (int i = 0; i < n; i++) {
			System.out.println("Introduce la altura " + (i + 1) + " :");
			num[i] = s.nextDouble();
			suma = suma + num[i];
		}
		double media = suma / n;

		for (int i = 0; i < n; i++) {
			if (num[i] >= media) {
				contS++;
			}
			if (num[i] < media) {
				contI++;
			}
		}
		System.out.println("La media de altura de las personas es " + media + ", hay " + contS
				+ " personas con una altura igual o superior a la media y " + contI
				+ " personas con una altura inferior a la media");
	}
}

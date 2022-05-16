package EjerciciosParte1;

import java.util.Scanner;

public class EjerciciosRepaso07 {
	static Scanner s = new Scanner(System.in);
	static int cont = 0;

	public static void main(String[] args) {
		System.out.println("Introduzca una palabra: ");
		String palabra = s.next();
		char[] capicua1 = new char[palabra.length()];
		char[] capicua2 = new char[palabra.length() / 2];
		for (int i = 0; i < palabra.length(); i++) {
			capicua1[i] = palabra.charAt(i);

		}
		for (int i = 0; i < capicua1.length / 2; i++) {
			capicua2[i] = capicua1[i];

		}
		for (int i = 0; i < capicua2.length; i++) {
			int x = (capicua1.length - 1) - i;
			if (capicua1[x] == capicua2[i])
				cont++;

		}
		if (cont == capicua2.length)
			System.out.println("La palabra introducida es capicua.");
		else
			System.out.println("La palabra introducida NO es capicua.");

	}

}

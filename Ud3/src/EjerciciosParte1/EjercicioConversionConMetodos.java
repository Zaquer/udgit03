package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioConversionConMetodos {
	public static double conversorCelsius(double gF) {
		double resultado = (gF - 32) * (5.0 / 9);
		return resultado;
	}

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
				Scanner s = new Scanner(System.in)) {
			double fahrenheit,resultado;
			System.out.println("Escriba cuantos grados fahrenheit quiere convertir en celsius.");
			fahrenheit = s.nextDouble();
			resultado=conversorCelsius(fahrenheit);
			System.out.println(fahrenheit + " grados fahrenheit son " + resultado + " grados celsius.");
		}
	}

}

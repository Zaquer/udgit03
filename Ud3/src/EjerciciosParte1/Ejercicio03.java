package EjerciciosParte1;

import java.util.Scanner;

public class Ejercicio03 {

	public static double conversor (double dolar, double valor) {
		return dolar*valor;
	}
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in)) {
				double dolares,valor;
				System.out.println("Escriba cuantos dolares quiere convertir en euros y la cotización del dolar con respecto al euro:");
				dolares=s.nextDouble();
				valor=s.nextDouble();
				System.out.println(dolares+ " dolares son "+ conversor(dolares,valor) + " euros.");
		}
	}
}

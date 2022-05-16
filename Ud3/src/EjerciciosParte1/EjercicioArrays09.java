package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays09 {

	public static double media(double[] x) {
		double contador = 0;
		for (int i = 0; i < limite; i++) {
			contador = contador + x[i];

		}
		if (limite==0)
			return 0;
		else 
		return contador / limite;
	}

	public static double suspensos(double[] x) {
		int contador = 0;
		for (int i = 0; i < limite; i++) {
			if (x[i] < 5) {
				contador++;
			}
		}
			return contador;
	}

	public static double aprobados(double[] x) {
		int contador = 0;
		for (int i = 0; i < limite; i++) {
			if (x[i] >= 5) {
				contador++;
			}
		}
		return contador;
	}
	
	public static double maxima(double[] x) {
		double contador = x [0];
		for (int i = 0; i < limite; i++) {
			if (x[i]>contador) {
				contador=x[i];
			}
		}
		if (limite==0)
			return 0;
		else
		return contador;
	}
	static int limite=0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double[] num = new double[30];
		System.out.println("Introduce 30 calificaciones por teclado: ");
		for (int i = 0; i < num.length; i++) {
			System.out.println("Introduce el estudiante " + (i+1) + " :");
			num[i] = s.nextDouble();
			if (num[i]>=0)
				limite++;
			if (num[i]<0)
				break;
		}
		System.out.print("Notas: ");
		for (int i = 0; i < limite; i++) {
			System.out.print("\nNota alumno "+(i+1)+": "+num[i]);
		}
		System.out.println("\nNota Media: " + media(num));
		System.out.println("Nº Suspensos: " + suspensos(num));
		System.out.println("Nº Aprobados: " + aprobados(num));
		System.out.println("Nota Maxima: " + maxima(num));
	}
}

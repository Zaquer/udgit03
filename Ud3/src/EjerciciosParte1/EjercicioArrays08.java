package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays08 {

	
	public static double media(double [] x) {
		double contador=0;
		for (int i = 0; i < x.length; i++) {
			contador=contador + x[i];
			
		}
		return contador/10;
	}
	
	public static double suspensos (double [] x) {
		int contador=0;
		for (int i = 0; i < x.length; i++) {
			if (x[i]<5) {
				contador++;
			}
		}
		return contador;
	}
	
	public static double aprobados (double [] x) {
		int contador=0;
		for (int i = 0; i < x.length; i++) {
			if (x[i]>=5) {
				contador++;
			}
		}
		return contador;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double [] num = new double [10];
		System.out.println("Introduce 10 calificaciones por teclado: ");
		for (int i = 0; i < num.length; i++) {
			System.out.println("Introduce el estudiante " + (i+1) + " :");
			num[i] = s.nextDouble();
		}
		
		System.out.print("Notas: ");
		for (int i = 0; i < num.length; i++) {
			System.out.println( "\nNota alumno "+(i+1)+": "+num[i]);
		}
		
		System.out.println("\nNota Media: "+ media(num));
		System.out.println("Nº Suspensos: "+ suspensos(num));
		System.out.println("Nº Aprobados: "+ aprobados(num));
		}
	}


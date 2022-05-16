package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays13 {
	public static void MMMalus(double [][] notas) {
		for(int i=0;i<notas.length;i++) {
			double max=notas[i][0];
			double min=notas[i][0];
			double media=0;
			
			for(int j=0;j<notas.length;j++) {
				if(max<notas[i][j]) {
					max=notas[i][j];
					}
				if(min>notas[i][j]) {
					min=notas[i][j];
					}
				media=media+notas[i][j];
			}
			System.out.println("Alumno "+(i+1)+": ");
			System.out.print(" La nota maxima: "+max);
			System.out.print(" La nota minima: "+min);
			System.out.print(" La media es: "+media/notas.length);
			System.out.println("");
		}
	}
	public static void MMMasig(double [][] notas) {
		for(int j=0;j<notas[0].length;j++) {
			double max=notas[0][j];
			double min=notas[0][j];
			double media=0;
		
			for(int i=0;i<notas.length;i++) {
			
			
				if(max<notas[i][j]) {
					max=notas[i][j];
					}
				if(min>notas[i][j]) {
					min=notas[i][j];
					}
				
				media=media+notas[i][j];
			}
			System.out.println("Asignatura "+(j+1)+": ");
			System.out.print(" La nota maxima: "+max);
			System.out.print(" La nota minima: "+min);
			System.out.print(" La media es: "+media/notas.length);
			System.out.println("");
		}
		}
	public static void MMMcurso(double [][] notas) {
		double media=0;
		double contador=0;
		double max=notas[0][0];
		double min=notas[0][0];
		for(int i=0;i<notas.length;i++) {
			for(int j=0;j<notas.length;j++) {
				if(max<notas[i][j]) {
					max=notas[i][j];
					}
				if(min>notas[i][j]) {
					min=notas[i][j];
					}
				media=media+notas[i][j];
				contador++;
			}
		}
			System.out.println("Curso: ");
			System.out.print(" La nota maxima: "+max);
			System.out.print(" La nota minima: "+min);
			System.out.print(" La media es: "+media/contador);
			System.out.println("");
	}	
	public static void pedirNota( double [][] notas) {
		Scanner  s=new Scanner(System.in);
		System.out.println("Escribe la nota que quieres buscar: ");
		double x=s.nextDouble();
		int contador=0;
		for(int i=0;i<notas.length;i++) {
			for(int j=0;j<notas.length;j++) {
				if(x==notas[i][j]) {
					System.out.println("La nota  "+x+" la tiene el alumno "+(i+1)+" en la asignatura "+(j+1));
					contador++;
				}
			}
		}
		if (contador==0) {
			System.out.println("Esta nota no la tiene ningun alumno.");
		}
	}
	public static void main(String[] args) {
		Scanner  s=new Scanner(System.in);
		double notas [][]= { {5.6,9.4,6.8,7},
							{6.9,5.2,5.7,6.3},
							{9.8,8,7.6,8.5}
						};
		MMMalus(notas);
		System.out.println("");
		MMMasig(notas);
		System.out.println("");
		MMMcurso(notas);
		System.out.println("");
		pedirNota(notas);
		System.out.println("");
	}
}
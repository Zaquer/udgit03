package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays15 {
	static Scanner s = new Scanner(System.in);
	static int fila = 3;
	static int columna = 3;
	static int[][] matriz = new int[fila][columna];
	static int[][] matrizAux = new int[matriz[0].length][matriz.length];
	
	public static void main(String[] args) {
		pedirnumeros(matriz);
		System.out.print("\nLa matriz original es:");
		
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("\t\n");	
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
		}
		transponer(matriz);
	}
	public static void pedirnumeros(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.println("Introduce el numero de la casilla " + (i + 1) + " , " + (j + 1));
				matriz[i][j] = s.nextInt();
			}
		}
		
	}
	public static void transponer(int[][] matriz) {
		System.out.print("\nLa matriz traspuesta es:");
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("\t\n");	
			for (int j = 0; j < matriz.length; j++) {
				matrizAux[i][j] = matriz[j][i];
				System.out.print(matrizAux[i][j]+" ");
			}
		}
	}

}

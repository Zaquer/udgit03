package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays16 {
	static Scanner s = new Scanner(System.in);
	static int fila = 2;
	static int columna = 2;
	static int[][] matriz = new int[fila][columna];

	public static boolean existenumero(int[][] matriz,int numero) {
		for (int i =0;i<matriz.length;i++) {
			for (int j =0;j<matriz.length;j++) {
				if (numero ==matriz[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void pedirnumeros(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.println("Introduce el numero de la casilla " + (i + 1) + " , " + (j + 1));
				matriz[i][j] = s.nextInt();
			}
		}
	}
	public static void suma(int[][] matriz) {
		
	}

	public static void main(String[] args) {
		pedirnumeros(matriz);
		boolean magica=true;
		for(int i =1;i<=matriz.length*matriz.length;i++) {
			if(existenumero(matriz, i)==false)
				magica=false;
		}
		if(magica==false) {
			System.out.println(magica);
		}
		if (magica==true) {
			suma(matriz);
			System.out.println(magica);
		}
		}
	}


package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays14 {
	static Scanner  s=new Scanner(System.in);

	public static void main(String[] args) {
		int fila=3;
		int columna=3;
		int [][] matriz=new int [fila][columna];
		
		pedirnumeros(matriz);

	}
 public static void pedirnumeros (int [][] matriz) {
	 int contador=0;
	 for(int i=0;i<matriz.length;i++) {
		 for(int j=0;j<matriz.length;j++) {
			 System.out.println("Introduce el numero de la casilla "+(i+1)+" , "+(j+1));
			 matriz[i][j]=s.nextInt();
			 }
		 }
	 
	 for(int i=0;i<matriz.length;i++) {
		 for(int j=0;j<matriz.length;j++) {
			 if (matriz[i][j]!=matriz[j][i]) {
				 contador++;
		 }
	 }
	 }
	 if(contador==0) {
	 	System.out.println("La matriz intruducida es simetrica");
	 }
	 else {
		 System.out.println("La matriz intruducida no es simetrica");
	 }
 
}
}

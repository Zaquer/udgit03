package EjerciciosParte1;

import java.util.Scanner;

public class Ejercicio01 {

	public static boolean par (int Par) {
		boolean z= (Par % 2==0);
		return z;
	}
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in)) {
				 System.out.printf("Introduce un numero para saber si es par:");
				 int x=s.nextInt();
				 System.out.println(par(x));
			}
		}
		 
	}
	



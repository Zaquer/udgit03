package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int [] num= new int[10];
		System.out.println("Introduce 10 numeros. ");
		for (int i=0;i<10;i++) {
			System.out.println("Introduce el elemento "+(i+1)+" :");
			num[i]=s.nextInt();
		}
		System.out.println("El orden inverso de los elementos es: ");
		
		for(int i=9;i>=0;i--) {
			System.out.println("Elemento nº "+ (i+1)+" ---> "+num[i]);
		}
	}

}

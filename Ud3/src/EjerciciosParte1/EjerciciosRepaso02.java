package EjerciciosParte1;

import java.util.Scanner;

public class EjerciciosRepaso02 {
	static int contPos=0;
	static int contNeg=0;
	static int cont0=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int [] num= new int[10];
		System.out.println("Introduce 10 numeros por teclado: ");
		for (int i=0;i<num.length;i++) {
			System.out.println("Introduce el elemento "+(i)+" :");
			num[i]=s.nextInt();
		}
		analisis(num);
		System.out.println("Hay "+contPos+" numeros positivos, "+contNeg+" numeros negativos y "+cont0+" ceros en el array.");
		
	}
	public static void analisis (int [] x) {
		for (int i=0;i<x.length;i++) {
			if(x[i]>0) {
			contPos++;
			}
			if (x[i]<0) {
				contNeg++;
			}
			if (x[i]==0) {
				cont0++;
			}
			
		}
	}

}

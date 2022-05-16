package EjerciciosParte1;

import java.util.Scanner;

public class EjerciciosRepaso03 {
	static int contPos=0;
	static int contNeg=0;
	static int sumaPos=0;
	static int sumaNeg=0;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int [] num= new int[10];
		System.out.println("Introduce 10 numeros por teclado: ");
		for (int i=0;i<num.length;i++) {
			System.out.println("Introduce el elemento "+(i)+" :");
			num[i]=s.nextInt();
		}
		analisis(num);
		
		System.out.println("La media de los numeros positivos es: "+(sumaPos/contPos));
		System.out.println("La media de los numeros negativos es: "+(sumaNeg/contNeg));
	}
	public static void analisis (int [] x) {
		for (int i=0;i<x.length;i++) {
			if(x[i]>0) {
			contPos++;
			sumaPos=sumaPos+x[i];
			System.out.println(contPos+" "+" "+sumaPos+" "+x[i]);
			}
			if (x[i]<0) {
				contNeg++;
				sumaNeg=sumaNeg+x[i];
				System.out.println(contNeg+" "+" "+sumaNeg+" "+x[i]);
			}
			
		}
	}

	}

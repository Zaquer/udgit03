package EjerciciosParte1;

import java.util.Scanner;

public class EjerciciosRepaso01 {

		public static int max (int [] x) {
			int z=x[0];
			for (int i=0;i<x.length;i++) {
				if(z>=x[i]) {
				z=x[i];
				}
			}
			return z;
		}
		
		public static int min (int [] x) {
			int z=x[0];
			for (int i=0;i<x.length;i++) {
				if(z<=x[i]) {
					z=x[i];
				}
			}
			return z;
		}
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner s = new Scanner(System.in);
			int [] num= new int[10];
			System.out.println("Introduce 10 numeros por teclado: ");
			for (int i=0;i<num.length;i++) {
				System.out.println("Introduce el elemento "+(i)+" :");
				num[i]=s.nextInt();
			}
			max(num);
			min(num);
			
			for (int i=0;i<num.length;i++) {
				System.out.print(num[i]);
				if (num[i]== max(num)) {
					System.out.print(" minimo");
				}
				if ((num[i])==(min(num))) {
					System.out.print(" maximo");
					
				}
				System.out.println("");
			}
		}

	}



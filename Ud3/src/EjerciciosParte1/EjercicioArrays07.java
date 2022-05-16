package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays07 {

	public static void rotar (int[] num) {
		int x = num[num.length-1];
		for (int i = num.length-1; i > 0; i--) {
			num[i] = num[i - 1];
		}
		num[0] = x;
		
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " , ");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int tamanyo=15;
		int[] num = new int[tamanyo];
		System.out.println("Introduce 15 numeros por teclado: ");
		for (int i = 0; i < num.length; i++) {
			System.out.println("Introduce el elemento " + (i) + " :");
			num[i] = s.nextInt();
		}
		rotar(num);
	}
}

package EjerciciosParte1;

import java.util.Scanner;

public class Ejercicio04 {
	public static double area(double radio) {
		final double PI=3.1416;
		return (PI*(Math.pow(radio,2)));
	}
	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
				Scanner s = new Scanner(System.in)) {
			System.out.print("Introduce el radio del circulo: ");
			int radio = s.nextInt();
			System.out.printf("El Area del circulo es: %.3f cm2", area(radio));
		}
	}
}

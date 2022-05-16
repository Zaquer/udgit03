import java.util.Scanner;

public class Pregunta1DME {
	public static Scanner s = new Scanner(System.in);
	public static String cadena;

	static char[] letras = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	static String[] codigo = { "· —", "— · · ·", "— · — ·", "— · ·", "·", "· · — ·", "— — ·", "· · · ·", "· ·",
			"· — — —", "— · —", "· — · ·", "— —", "— ·", "— — —", "· — — ·", "— — · —", "· — ·", "· · ·", "—", "· · —",
			"· · · —", "· — —", "— · · —", "— · — —", "— — · ·" };

	//
	public static int posicion(char letra) {
		for (int i = 0; i < letras.length; i++) {
			if (letras[i] == letra) {
				return i;
			}
		}
		return 0;
	} // de posicion

	public static void main(String[] args) {
		System.out.println("Introduzca la cadena a codificar: ");
		System.out.println("Por favor solo mayusculas.");
		cadena = s.nextLine();
		char cadenaC;

		int longitud = cadena.length();
		char[] cadenaA = new char[longitud];

		for (int i = 0; i < cadena.length(); i++) {
			cadenaC = cadena.charAt(i);
			cadenaA[i] = cadenaC;
			int posi = posicion(cadenaA[i]);
			if (cadenaA[i] == ' ') {
				System.out.print("");
			} else
				System.out.print(codigo[posi]);
			System.out.print("b");
		}

	} // del main

}

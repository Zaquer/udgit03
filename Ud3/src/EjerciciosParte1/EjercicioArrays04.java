package EjerciciosParte1;

public class EjercicioArrays04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] caracter = new char[10];
		caracter[0] = 'a';
		caracter[1] = 'x';
		caracter[4] = '@';
		caracter[6] = ' ';
		caracter[7] = '+';
		caracter[8] = 'Q';

		for (int i = 0; i < 10; i++) {
			System.out.println("Elemento nº " + (i+1) + " ---> " + caracter[i]);
		}
		//En las casillas sin valores el array deja dichos valores vacios.
	}
}

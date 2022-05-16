package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cont=1;
		System.out.print("Introduce un numero binario de 8 digitos: ");
		String bin1=s.nextLine();
		int [] bin=new int [bin1.length()];
		for(int i=0;i<bin1.length(); i++) {
			bin[i]=Character.getNumericValue(bin1.charAt(i));
		}
		double suma=0;
		int exponente=0;
		for(int j=bin1.length()-1; j>=0; j--) {
			if(bin[j]==1 || bin[j]==0) {
				if(bin[j]==1) {
					suma=suma+Math.pow(2, exponente);
					exponente++;
				}
				if(bin[j]==0) {
					exponente++;
				}
			}
			else {
				System.out.print("El numero introducido no es binario.");
				System.exit(0);
			}
			
		}
		System.out.print("Su valor decimal es "+suma);
	}

}

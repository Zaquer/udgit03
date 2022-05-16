package EjerciciosParte1;

public class EjercicioArrays03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num= new int[12];
		num[0]=39; num[1]=-2; num[4]=0; num[6]=14; num[8]=5; num[9]=120;
		
		for (int i=0;i<12;i++) {
			System.out.println("Elemento nº "+(i+1)+" ---> "+num[i]);
			
			//En las casillas sin valores el array le asigna un 0 al valor.
		}
	}

}

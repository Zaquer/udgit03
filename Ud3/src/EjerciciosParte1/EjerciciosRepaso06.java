package EjerciciosParte1;

public class EjerciciosRepaso06 {

	public static void main(String[] args) {
		int n=20;
		int[] num = new int[n];
		boolean primo=false;
		int[] primos = new int[n];
		for (int i = 0; i < num.length; i++) {
			num[i] = ((int) (Math.random() * 100));
			
		}
		for (int i = 0; i < num.length; i++) {
			int x=num[i];
			for (int j = 2; j < num.length/2; j++) {
			if ((x % j) == 0) {
				primo=false;
				break;
			}
			else
				primo=true;
			}
			if(primo)
				primos[i]=x;
		}
		System.out.println("Array entero: ");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]+" ");
		}
		System.out.println();
		System.out.println("Array de solo primos: ");
		for (int i = 0; i < num.length; i++) {
			if(primos[i]!=0)
			System.out.print(primos[i]+" ");
		}
			
		}

	}



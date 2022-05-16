public class Pregunta2DME {
	
	public static void totalSal(double [][] salarios){
		double suma = 0;
		
		for (int i = 0; i < salarios.length; i++) {
			for (int j = 0; j < salarios[i].length; j++) {
				suma =suma + salarios[i][j];
			}
		}
		System.out.println("El salario total es: " + suma);
	}
	
	public static void maxMes(double [][] salarios) {
		double max = salarios[0][0];
		
		for (int j = 0; j < salarios.length; j++) {
			for (int i = 0; i < salarios[j].length; i++) {
				if (salarios[j][i] > max) {
					max = salarios[j][i];
				}
			}
		}
		System.out.println("El salario máximo es: " + max);
	}
	
	public static void maxTri(double [][] salarios, String [] empleados) {
		double [] maxSal = new double [empleados.length];
		for(int i = 0; i < salarios.length; i++) {
			for (int j = 0; j < salarios[i].length;j++) {
				maxSal[i] = maxSal[i] + salarios[i][j];
			}
		}
		double max = maxSal[0];
		for (int l = 0; l < maxSal.length; l++) {
			if(maxSal[l] > max) {
				max = maxSal[l];
			}
		}
		System.out.print("El salario trimestral máximo es: " + max + ", y lo cobran: ");
		for (int t = 0; t < empleados.length; t++) {
			if(max == maxSal[t]) {
				System.out.print( empleados[t] + " | ");
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		String [] empleados = {"Alberto Carrera", "Luis Aldea", "Leticia García", "Ana Ereza", "Belén Carrera"};
		double [][] salarios = {{540, 540, 760},
				                {200, 220, 250},
				                {760, 760, 760},
				                {605, 799, 810},
				                {800, 800, 680}
							   };
		totalSal(salarios);
		maxMes(salarios);
		maxTri(salarios, empleados);
		
	} // del main

	}//  de la clase Pregunta2


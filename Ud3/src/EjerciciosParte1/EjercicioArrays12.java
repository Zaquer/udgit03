package EjerciciosParte1;

import java.util.Scanner;

public class EjercicioArrays12 {
	
	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.print("Introduce una frase: ");
	String frase=s.nextLine();
	char [] caracteres = new char[frase.length()];
	int a=0;
	int e=0;
	int i=0;
	int o=0;
	int u=0;
		for(int j=0; j<frase.length();j++) {
			caracteres[j]=frase.charAt(j);
		
		}
		for(int j=0; j<caracteres.length;j++) {
		if (caracteres[j]=='a'||caracteres[j]=='A') {
			a++;}
		if (caracteres[j]=='e'||caracteres[j]=='E') {
			e++;}
		if (caracteres[j]=='i'||caracteres[j]=='I') {
			i++;}
		if (caracteres[j]=='o'||caracteres[j]=='O') {
			o++;}
		if (caracteres[j]=='u'||caracteres[j]=='U') {
			u++;}
		}
		System.out.println("Nº de A: "+a);
		System.out.println("Nº de E: "+e);
		System.out.println("Nº de I: "+i);
		System.out.println("Nº de O: "+o);
		System.out.println("Nº de U: "+u);
}
}

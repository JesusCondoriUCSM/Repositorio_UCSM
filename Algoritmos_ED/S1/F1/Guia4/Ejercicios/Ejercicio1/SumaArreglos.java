package Ejer1;
import java.util.*;
public class SumaArreglos {
	
	public static boolean esPotencia(int elemento) {
		double resultado=0;
		int i=0;
		
		for(int y=0;y<=elemento;y++) {
			resultado=Math.pow(2,i++);
			if(resultado==elemento) {
				//System.out.println(lista[x]);
				return true;
			}
		}
		return false;
	}
	public static boolean suma(int lista[],int total) {
		int suma=0;
		int cont=0;
		for(int x=0;x<lista.length;x++) {
			
			cont++;
			if(lista[x]%5==0 && cont!=lista.length && lista[x+1]%2!=0) {
				//System.out.println(lista[x]);
				continue;
			}
			if(esPotencia(lista[x])) {	//Verifica si es potencia
				suma+=lista[x];
			}else {
				suma+=lista[x];
			}
			
		}
		System.out.println(suma);
		if(suma==total) {
			return true;
		}
		return false;
		
	}
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		int num;
		System.out.println("Cantidad de elementos del arreglo: "); //Cantidad elementos
		int cantidad=sc.nextInt();
		int listaNum[]=new int[cantidad]; 	//Creacion del arreglo
		System.out.println("Elementos: ");
		for(int i=0;i<cantidad;i++) {
			num=sc.nextInt();
			listaNum[i]=num;		//Almacena numeros al arreglo
		}
		
		System.out.println("Objetivo suma: ");
		int suma=sc.nextInt();
		
		boolean comprobar=suma(listaNum,suma);
		System.out.println(comprobar);
	}
}

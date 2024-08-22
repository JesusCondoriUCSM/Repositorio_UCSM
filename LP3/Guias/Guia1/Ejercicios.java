//Ejercicio1
package lp4;

public class Ejercicio1 {
	public static void main(String[]args) {
		int arr[]= {1,2,3,4,5};
		System.out.println("La suma de los elementos del array es: " + funcion(arr));
		
	}
	public static int funcion(int [] arr) {
		int acumulador=0;
		for(int i=0;i<arr.length;i++) {
			acumulador+=arr[i];
		}
		return acumulador;
	}
}
//Ejercicio2
package lp4;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		int [] arr=new int[10];
		Scanner scanner=new Scanner(System.in);
		int numero;
		System.out.println("Ingrese un numero: ");
		numero=scanner.nextInt();
		arr[0]=numero;
		int cant=1;
		while(cant<10) {
			System.out.println("Ingrese un numero: ");
			numero=scanner.nextInt();
			if(arr[cant-1]<numero) {
				arr[cant]=numero;
				cant++;
			}
		}
		for(int i:arr) {
			System.out.println(i);
		}
	}
	
}
//Ejercicio3
package lp4;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		int [] arr=new int[10];
		Scanner scanner=new Scanner(System.in);
		int numero;
		System.out.println("Ingrese un numero: ");
		numero=scanner.nextInt();
		arr[0]=numero;
		int cant=1;
		while(cant<10) {
			System.out.println("Ingrese un numero: ");
			numero=scanner.nextInt();
			if(arr[cant-1]<numero) {
				arr[cant]=numero;
				cant++;
			}
		}
		for(int i:arr) {
			System.out.println(i);
		}
	}
	
}
//Ejercicio3
package lp4;

import java.util.Random;

public class Ejercicio3 {
    public static void main(String[] args) {
        Random random = new Random();
        
        int min = 1; 
        int max = 6;
        int []arr= {0,0,0,0,0,0};
        for(int i=0;i<20000;i++) {
        	int random_numero = random.nextInt(max) + min;
        	if(random_numero==1) {
        		arr[0]+=1;
        	}
        	else if(random_numero==2){
        		arr[1]+=1;
        	}
        	else if(random_numero==3){
        		arr[2]+=1;
        	}
        	else if(random_numero==4){
        		arr[3]+=1;
        	}
        	else if(random_numero==5){
        		arr[4]+=1;
        	}
        	else if(random_numero==6){
        		arr[5]+=1;
        	}
        }
        System.out.println("Al girar 20000 un dado veces se obtuvo estos resultados");
        for(int y:arr) {
        	System.out.println(y);
        }
        
    }
}
//Ejercicio4
package lp4;

public class Ejercicios4 {
	public static void main(String[] args) {
		double num1=1.41;
		double num2=1.45;
		double num3=0.48;
		System.out.println(menor(num1,num2,num3));
		
	}
	public static double menor (double n1, double n2, double n3) {
		if((n1<n2) && (n1<n3)) {
			return n1;
		}
		else if(n2<n1 && n2<n3) {
			return n2;
		}
		else if(n3<n1 && n3<n2) {
			return n3;
		}
		return 0.0;
	}
}
//Ejercicio5
package lp4;
import java.util.Scanner;

public class Ejercicios5 {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Ingrese la cantidad de horas: ");
		int horas= scanner.nextInt();
		cargo(horas);
	}
	
	public static void cargo(int h) {
		double cargo=3.0;
		int cant_horas=1;
		while (cant_horas<h) {
			cargo+=0.50;
			cant_horas++;
		}
		System.out.println("El cargo total por " + h + " horas es: "+ cargo);
	}
}
//Ejercicio6
package lp4;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de horas: ");
        int horas = scanner.nextInt();
        System.out.print("Introduce el número de minutos: ");
        int minutos = scanner.nextInt();
        System.out.print("Introduce el número de segundos: ");
        int segundos = scanner.nextInt();
        int Segundos_total = (horas * 3600) + (minutos * 60) + segundos;
        System.out.println("El equivalente en segundos es: " + Segundos_total);
    }
}


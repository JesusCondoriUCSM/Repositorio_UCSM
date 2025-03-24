package AED_1F2_E3;

import java.util.Scanner;

import AED_1F2_E2.OperacionesMatDouble;

public class Main {
	public static void main (String [] args) {
		int opc=0;
		Scanner sc=new Scanner(System.in);
		double num1,num2;
		while(opc!=8) {
			
			System.out.println("1.Suma\n2.Resta\n3.Producto\n4.Division\n5.Potencia\n6.Raiz cuadrada\n7.Raiz cubica\n8.Salir");
			opc=sc.nextInt();
			switch(opc) {
			case 1:
				System.out.println("Ingrese los numeros");
				num1=sc.nextDouble();
				num2=sc.nextDouble();
	
				System.out.println("La suma es: "+Calculadora.suma(num1, num2));
				break;
				
			case 2:
				
				System.out.println("Ingrese los dos numeros a restar");
				num1=sc.nextDouble();
				num2=sc.nextDouble();
	
				System.out.println("La resta es: "+Calculadora.resta(num1, num2));
				break;
				
			case 3:
				
				System.out.println("Ingrese los dos numeros a multiplicar");
				num1=sc.nextDouble();
				num2=sc.nextDouble();
	
				System.out.println("El producto es: "+Calculadora.producto(num1, num2));
				break;
				
			case 4:
				
				System.out.println("Ingrese los dos numeros a dividir");
				num1=sc.nextDouble();
				num2=sc.nextDouble();
				
				while(num2==0) {
					System.out.println("Ingrese un numero valido");
					num2=sc.nextDouble();

				}
				System.out.println("La division es: "+Calculadora.division(num1, num2));
				break;
					
			case 5:
				System.out.println("Ingrese el numero base");
				num1=sc.nextDouble();
				System.out.println("Ingrese el exponente");
				num2=sc.nextDouble();
	
				System.out.println("La potencia es: "+Calculadora.potencia(num1, num2));
				break;
				
			case 6:
				
				System.out.println("Ingrese el numero");
				num1=sc.nextDouble();
				
				System.out.println("La raiz cuadrada es: "+Calculadora.raizCuadrada(num1));
				break;
				
			case 7:
				System.out.println("Ingrese el numero");
				num1=sc.nextDouble();
				
	
				System.out.println("La raiz cubica es: "+Calculadora.raizCubica(num1));
				break;
				
			case 8:
				
				System.out.println("Saliendo el programa...");
				break;
			default:
				System.out.println("Opcion invalida");

			}
		}
		
	}
	
	
}

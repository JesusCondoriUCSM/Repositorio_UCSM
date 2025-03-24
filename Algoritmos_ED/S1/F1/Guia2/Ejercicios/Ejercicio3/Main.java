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
				System.out.println("Ingrese los numeros a sumar");
				
				if(sc.hasNextInt()) {
					num1=sc.nextInt();
					num2=sc.nextInt();
					System.out.println("La suma es: "+CalculadoraI.suma(num1, num2));
					System.out.println("Los datos ingresados fueron enteros");

				}
				else if(sc.hasNextDouble()){
					num1=sc.nextDouble();
					num2=sc.nextDouble();
					System.out.println("La suma es: "+CalculadoraD.suma(num1, num2));
					System.out.println("Los datos ingresados fueron double");
				}
				break;
				
			case 2:
				
				System.out.println("Ingrese los numeros a restar");
				
				if(sc.hasNextInt()) {
					num1=sc.nextInt();
					num2=sc.nextInt();
					System.out.println("La resta es: "+CalculadoraI.resta(num1, num2));
					System.out.println("Los datos ingresados fueron enteros");

				}
				else if(sc.hasNextDouble()){
					num1=sc.nextDouble();
					num2=sc.nextDouble();
					System.out.println("La resta es: "+CalculadoraD.resta(num1, num2));
					System.out.println("Los datos ingresados fueron double");
				}
				break;
				
			case 3:
				
				System.out.println("Ingrese los numeros a multiplicar");
				
				if(sc.hasNextInt()) {
					num1=sc.nextInt();
					num2=sc.nextInt();
					System.out.println("El producto es: "+CalculadoraI.producto(num1, num2));
					System.out.println("Los datos ingresados fueron enteros");

				}
				else if(sc.hasNextDouble()){
					num1=sc.nextDouble();
					num2=sc.nextDouble();
					System.out.println("El producto es: "+CalculadoraD.producto(num1, num2));
					System.out.println("Los datos ingresados fueron double");
				}
				break;
				
			case 4:
				
				System.out.println("Ingrese los numeros a dividir");
				
				if(sc.hasNextInt()) {
					num1=sc.nextInt();
					num2=sc.nextInt();
					while(num2==0) {
						System.out.println("Ingrese un numero valido");
						num2=sc.nextInt();

					}
					System.out.println("El producto es: "+CalculadoraI.division(num1, num2));
					System.out.println("Los datos ingresados fueron enteros");

				}
				else if(sc.hasNextDouble()){
					num1=sc.nextDouble();
					num2=sc.nextDouble();
					while(num2==0) {
						System.out.println("Ingrese un numero valido");
						num2=sc.nextDouble();

					}
					System.out.println("El producto es: "+CalculadoraD.division(num1, num2));
					System.out.println("Los datos ingresados fueron double");
				}
				
				break;
					
			case 5:
				System.out.println("Ingrese la base");
				if(sc.hasNextInt()) {
					
					num1=sc.nextInt();
					System.out.println("Ingrese el exponente");
					num2=sc.nextInt();
					System.out.println("La potencia es: "+CalculadoraI.potencia(num1, num2));
					System.out.println("Los datos ingresados fueron enteros");

				}
				else if(sc.hasNextDouble()){
					num1=sc.nextDouble();
					System.out.println("Ingrese el exponente");
					num2=sc.nextDouble();
					System.out.println("El producto es: "+CalculadoraD.producto(num1, num2));
					System.out.println("Los datos ingresados fueron double");

				}
				break;
				
			case 6:
				
				System.out.println("Ingrese el numero");
				
				if(sc.hasNextInt()) {
					num1=sc.nextInt();
					System.out.println("La raiz cuadrada es: "+CalculadoraI.raizCuadrada(num1));
					System.out.println("El dato ingresado fue entero");

				}
				else if(sc.hasNextDouble()){
					num1=sc.nextDouble();
					System.out.println("La raiz cuadrada es: "+CalculadoraD.raizCuadrada(num1));
					System.out.println("El dato ingresado fue double");
				}
				break;
				
			case 7:
				System.out.println("Ingrese el numero");
				
				if(sc.hasNextInt()) {
					num1=sc.nextInt();
					System.out.println("La raiz cubica es: "+CalculadoraI.raizCubica(num1));
					System.out.println("El dato ingresado fue entero");

				}
				else if(sc.hasNextDouble()){
					num1=sc.nextDouble();
					System.out.println("La raiz cubica es: "+CalculadoraD.raizCubica(num1));
					System.out.println("El dato ingresado fue double");
				}
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

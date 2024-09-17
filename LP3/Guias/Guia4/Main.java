//Ejercicio 2
package lp1_4_2;
import java.util.Scanner;
class DivisionPorCeroException extends IllegalArgumentException{
	public DivisionPorCeroException(String m) {
		super(m);
	}
}
class Calculadora{
	public Calculadora() {}
	public void suma(double n1,double n2) {
		double resultado=n1+n2;
		System.out.println("Suma: "+resultado);
	}
	public void resta(double n1,double n2) {
		double resultado=n1-n2;
		System.out.println("Resta: "+resultado);
	}
	public void multiplicacion(double n1,double n2) {
		double resultado=n1*n2;
		System.out.println("Multiplicación: "+resultado);
	}
	public void division(double n1,double n2) {
		try {
			if(n2==0) {
				throw new DivisionPorCeroException(" Division entre 0");
				}
			double resultado=n1/n2;
			System.out.println("Resultado: "+resultado);
		}
		catch(DivisionPorCeroException d){
			System.out.println("Error:"+d.getMessage());
		}
		catch (ArithmeticException a) {
			System.out.println("Error: "+a.getMessage());
		}
	}
	
}
public class Main {
	
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int opc=0;
		while(opc!=5) {
			System.out.println("Ingrese los números a operar: ");
			double n1=scanner.nextDouble();
			double n2=scanner.nextDouble();
			System.out.println("Elija una operación:");
			System.out.println("1.Suma\n2.Resta\n3.Multiplicación\n4.División\n5.Salir");
			opc = scanner.nextInt();
			Calculadora calcula=new Calculadora();
			switch(opc) {			
			case 1:
				calcula.suma(n1, n2);
				calcula=null; //Libera el objeto
				break;
			case 2:
				calcula.resta(n1, n2);
				calcula=null;
				break;
			case 3:
				calcula.multiplicacion(n1, n2);
				calcula=null;
				break;
			case 4:
				calcula.division(n1, n2);
				calcula=null;
				break;
			case 5:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción invalida");
			}
		}
	}
}

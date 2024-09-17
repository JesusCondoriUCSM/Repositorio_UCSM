//Ejercicio 3
package lp1_4;
import java.util.Scanner;


class Numero{
	private double valor=0;
	public Numero() {}
	public void setValor(double v) {
		try {
		if(v<0) {
			throw new IllegalArgumentException(" Valor negativo");
		}
		this.valor=v;
		System.out.println("Valor almacenado correctamente");
		}
		catch(IllegalArgumentException i) {
			System.out.println("Error: "+i.getMessage());
		}
	}
	public double getValor() {return this.valor;}
}

public class MainNega {
	public static void main(String [] args) {
		Scanner scanner =new Scanner(System.in);
		int opc=0;
		Numero num=new Numero();
		while(opc!=5) {
			System.out.println("Elija una opción:");
			System.out.println("1.Establecer valor\n2.Obtener valor\n3.Salir");
			opc = scanner.nextInt();
			switch(opc) {			
			case 1:
				System.out.println("Ingrese el número a almacenar: ");
				double n=scanner.nextDouble();
				num.setValor(n);
				break;
			case 2:
				System.out.println("Valor: "+num.getValor());
				break;
			case 3:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción invalida");
			}
		}
	}
}

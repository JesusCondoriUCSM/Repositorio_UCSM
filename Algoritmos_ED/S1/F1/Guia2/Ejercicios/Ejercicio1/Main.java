package AED_1F2_E;

public class Main {

	public static void main(String []args) {
		OperacionesMatBInteger operacionesMatBInteger = new OperacionesMatBInteger();
		System.out.println(operacionesMatBInteger.suma(1, 100));
		
		/*OperacionesMatB<Integer> operacionesMatB = new OperacionesMatB<>();
		System.out.println(operacionesMatBInteger.suma(1, 100));
		*/
		OperacionesMatDouble operacionesMatDouble = new OperacionesMatDouble();
		
		System.out.println(operacionesMatDouble.suma(1.0, 100.0));
		
		System.out.println(operacionesMatDouble.resta(100.0, 100.0));

		System.out.println(operacionesMatDouble.producto(1.0, 100.0));

		System.out.println(operacionesMatDouble.division(1.0, 100.0));

	}
	
}

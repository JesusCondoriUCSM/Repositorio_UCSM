package AED_1F2_E2;
import java.util.*;

public class Main {
	public static void main (String [] args) {
		
		OperacionesMatDouble<Double> oD= new OperacionesMatDouble<> ();
		System.out.println(oD.suma(3.4, 4.5));
		
		OperacionesMatInteger <Integer>oI = new OperacionesMatInteger<>();
		System.out.println(oI.suma(1, 3));

	}
}

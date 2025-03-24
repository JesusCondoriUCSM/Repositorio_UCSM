package AED_1F2_E3;

public class CalculadoraI {
	
	//Suma
	public static <T extends Number> T suma(T n1, T n2) {
		
		return (T) Integer.valueOf(n1.intValue()+n2.intValue());
	}
	//Resta
	public static <T extends Number> T resta(T n1, T n2) {
		
		return (T) Integer.valueOf(n1.intValue()-n2.intValue());
	}
	//Producto
	public static <T extends Number> T producto(T n1, T n2) {
		
		return (T) Integer.valueOf(n1.intValue()*n2.intValue());
	}
	//Division
	public static <T extends Number> T division(T n1, T n2) {
		
		return (T) Integer.valueOf(n1.intValue()/n2.intValue());
	}
	//Potencia
	public static <T extends Number> T potencia(T n1, T n2) {
		
		Integer verificar = (Integer) Integer.valueOf(n2.intValue());
		if(verificar==0) {
			return (T) Integer.valueOf(1);
		}
		return (T) Double.valueOf(Math.pow(n1.intValue(),n2.intValue()));

	}
	//Raiz Cuadrada
	public static <T extends Number> T raizCuadrada(T n1) {
		return (T) Double.valueOf(Math.sqrt(n1.doubleValue()));
	}
	//Raiz Cubica
	public static <T extends Number> T raizCubica(T n1) {
		return (T) Double.valueOf(Math.cbrt(n1.doubleValue()));
	}
}

package AED_1F2_E3;

public class CalculadoraD {
	
	//Suma
	public static <T extends Number> T suma(T n1, T n2) {
		
		return (T) Double.valueOf(n1.doubleValue()+n2.doubleValue());
	}
	//Resta
	public static <T extends Number> T resta(T n1, T n2) {
		
		return (T) Double.valueOf(n1.doubleValue()-n2.doubleValue());
	}
	//Producto
	public static <T extends Number> T producto(T n1, T n2) {
		
		return (T) Double.valueOf(n1.doubleValue()*n2.doubleValue());
	}
	//Division
	public static <T extends Number> T division(T n1, T n2) {
		
		return (T) Double.valueOf(n1.doubleValue()/n2.doubleValue());
	}
	//Potencia
	public static <T extends Number> T potencia(T n1, T n2) {
		
		Double verificar = (Double) Double.valueOf(n2.doubleValue());
		if(verificar==0) {
			return (T) Double.valueOf(1);
		}
		return (T) Double.valueOf(Math.pow(n1.doubleValue(),n2.doubleValue()));

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

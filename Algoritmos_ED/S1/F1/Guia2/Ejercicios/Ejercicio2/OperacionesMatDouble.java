package AED_1F2_E2;

public class OperacionesMatDouble <T extends Number>implements Operable <T> {

	@Override
	public T suma(T operando1, T operando2) {
		return (T) Double.valueOf( operando1.doubleValue() + operando2.doubleValue());
	}
	
	@Override
	public T resta(T operando1, T operando2) {
		return (T) Double.valueOf( operando1.doubleValue() - operando2.doubleValue());
	}
	
	@Override
	public T producto(T operando1, T operando2) {
		return (T) Double.valueOf( operando1.doubleValue() * operando2.doubleValue());
	}
	
	@Override
	public T division(T operando1, T operando2) {
		return (T) Double.valueOf( operando1.doubleValue() / operando2.doubleValue());
	}
}

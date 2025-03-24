package AED_1F2_E2;

public class OperacionesMatInteger <T extends Number>implements Operable <T> {

	@Override
	public T suma(T operando1, T operando2) {
		return (T) Integer.valueOf( operando1.intValue() + operando2.intValue());
	}
	
	@Override
	public T resta(T operando1, T operando2) {
		return (T) Integer.valueOf( operando1.intValue() - operando2.intValue());
	}
	
	@Override
	public T producto(T operando1, T operando2) {
		return (T) Integer.valueOf( operando1.intValue() * operando2.intValue());
	}
	
	@Override
	public T division(T operando1, T operando2) {
		return (T) Integer.valueOf( operando1.intValue() / operando2.intValue());
	}
}

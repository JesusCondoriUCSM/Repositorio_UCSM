package AED_1F2_E;

public class OperacionesMatDouble implements Operable<Double>{

	@Override
	public Double suma(Double operando1, Double operando2) {
		return operando1 + operando2;
	}
	
	@Override
	public Double resta(Double operando1, Double operando2) {
		return operando1 - operando2;
	}
	
	@Override
	public Double producto(Double operando1, Double operando2) {
		return operando1 * operando2;
	}
	
	@Override
	public Double division(Double operando1, Double operando2) {
		return operando1 / operando2;
	}

}

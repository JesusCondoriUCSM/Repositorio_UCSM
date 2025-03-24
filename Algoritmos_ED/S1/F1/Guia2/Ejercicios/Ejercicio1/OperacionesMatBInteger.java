package AED_1F2_E;

public class OperacionesMatBInteger  implements Operable<Integer>{

	@Override
	public Integer suma(Integer operando1, Integer operando2) {
		return operando1 + operando2;
	}
	
	@Override
	public Integer resta(Integer operando1, Integer operando2) {
		return operando1 - operando2;
	}
	
	@Override
	public Integer producto(Integer operando1, Integer operando2) {
		return operando1 * operando2;
	}
	
	@Override
	public Integer division(Integer operando1, Integer operando2) {
		return operando1 / operando2;
	}
	
	
	
}

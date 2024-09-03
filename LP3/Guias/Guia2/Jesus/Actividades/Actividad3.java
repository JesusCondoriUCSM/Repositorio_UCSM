//Automovil
package lp4_3;

public class Automovil {
	private String placa;
	private int numPuertas;
	private String marca;
	private String modelo;
	private Motor motor;
	public Automovil(String placa, int nPuertas, String marca, String modelo,Motor motor) {
		this.placa=placa;
		this.numPuertas=nPuertas;
		this.marca=marca;
		this.modelo=modelo;
		this.motor=motor;
	}
	public String toString() {
		return "El numero de placa es: "+this.placa +
		"\nEl numero de puertas es: "+this.numPuertas+
		"\nLa marca es: "+this.marca+
		"\nEl modelo es: "+this.modelo+
		"\n"+this.motor.toString();
	}
	public void setPlaca(String placa) { 
		this.placa=placa;
	}
	public String getPlaca() {
		return placa; 
	}
	public void setnumPuertas(int numPuertas) {
		this.numPuertas=numPuertas; 
	}
	public int getnumPuertas() {
		return numPuertas; 
	}
	public void setMarca(String marca) {
		this.marca=marca;
	}
	public String getMarca() {
		return marca;
	}
	public void SetModelo(String modelo) {
		this.modelo=modelo;
	}
	public String getModelo() {
		return modelo;
	}
}

//Motor
package lp4_3;


public class Motor {
	private int numMotor;
	private int revPorMin;
	public Motor(int numMotor,int revPorMin) {
		this.numMotor=numMotor;
		this.revPorMin=revPorMin;
	}
	public String toString() {
		return "Numero de motor del automovil es: "+this.numMotor +
		"\nRevoluciones del automovil son: "+this.revPorMin;
	}
	public void setNumMotor(int n){
		this.numMotor=n;
	}
	public int getNumMotor() {
		return this.numMotor;
	}
	public void setrevPorMin(int r){
		this.revPorMin=r;
	}
	public int getrevPorMin() {
		return this.revPorMin;
	}
}

//Main
package lp4_3;

public class TestAgregacion {
	public static void main(String[] args) {
		Motor motor=new Motor(8,5000);
		Automovil auto=new Automovil("ADS1",4,"Nissan","A32",motor);
		System.out.println(auto.toString());
	}
}

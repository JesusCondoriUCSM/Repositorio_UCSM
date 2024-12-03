package Ejer3;


class Aire {
	public void encender() {
		System.out.println("Se encendió el aire acondicionado");
	}
	public void apagar() {
		System.out.println("Se apagó el aire acondicionado");
	
	}
	
}
class EncenderAireComando implements Command {
	private Aire aire;
	public EncenderAireComando(Aire a) {
		this.aire=a;
	}
	public void ejecutar() {
		aire.encender();
	}
	public void deshacer() {
		aire.apagar();
	}
}
class ApagarAireComando implements Command {
	private Aire aire;
	public ApagarAireComando(Aire a) {
		this.aire=a;
	}
	public void ejecutar() {
		aire.apagar();
	}
	public void deshacer() {
		aire.encender();
	}
}

package Ejer3;


class Ventilador {
	public void encender() {
		System.out.println("Se encendió el ventilador");
	}
	public void apagar() {
		System.out.println("Se apagó el ventilador");
	
	}
	
}
class EncenderVenComando implements Command {
	private Ventilador ven;
	public EncenderVenComando(Ventilador ven) {
		this.ven=ven;
	}
	public void ejecutar() {
		ven.encender();
	}
	public void deshacer() {
		ven.apagar();
	}
}
class ApagarVenComando implements Command {
	private Ventilador ven;
	public ApagarVenComando(Ventilador v) {
		this.ven=v;
	}
	public void ejecutar() {
		ven.apagar();
	}
	public void deshacer() {
		ven.encender();
	}
}

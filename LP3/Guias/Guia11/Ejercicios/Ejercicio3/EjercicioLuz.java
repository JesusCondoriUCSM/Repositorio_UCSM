package Ejer3;

interface Command{
	void ejecutar();
	void deshacer();
}

class Luz {
	public void encender() {
		System.out.println("Se encendió la luz");
	}
	public void apagar() {
		System.out.println("Se apagó la luz");
	
	}
	
}
class EncenderLuzComando implements Command {
	private Luz luz;
	public EncenderLuzComando(Luz luz) {
		this.luz=luz;
	}
	public void ejecutar() {
		luz.encender();
	}
	public void deshacer() {
		luz.apagar();
	}
}
class ApagarLuzComando implements Command {
	private Luz luz;
	public ApagarLuzComando(Luz luz) {
		this.luz=luz;
	}
	public void ejecutar() {
		luz.apagar();
	}
	public void deshacer() {
		luz.encender();
	}
}

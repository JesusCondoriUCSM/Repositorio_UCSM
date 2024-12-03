package Ejer3;


class ControlRemoto {
	private Command prenderLuzComando;
	private Command apagarLuzComando;
	private Command prenderVenComando;
	private Command apagarVenComando;
	private Command prenderAireComando;
	private Command apagarAireComando;
	private Command ultimaAccion;
	
	public void setPrenderLuzComando(Command prenderLuzComando) {
		this.prenderLuzComando=prenderLuzComando;
	}
	public void setApagarLuzComando(Command apagarLuzComando) {
		this.apagarLuzComando=apagarLuzComando;
	
	}
	
	public void setPrenderLVenComando(Command prenderVenComando) {
		this.prenderVenComando=prenderVenComando;
	}
	public void setApagarVenComando(Command apagarVenComando) {
		this.apagarVenComando=apagarVenComando;
	
	}
	
	public void setPrenderAireComando(Command prenderAireComando) {
		this.prenderAireComando=prenderAireComando;
	}
	public void setApagarAireComando(Command apagarAireComando) {
		this.apagarAireComando=apagarAireComando;
	
	}
	
	public void pressPrenderLuz() { //Acciones de la luz
		prenderLuzComando.ejecutar();
		ultimaAccion= prenderLuzComando;
	}
	public void pressApagarLuz() {
		apagarLuzComando.ejecutar();
		ultimaAccion= apagarLuzComando;
	}
	
	public void pressPrenderVen() { //Acciones del ventilador
		prenderVenComando.ejecutar();
		ultimaAccion= apagarVenComando;
	}
	public void pressApagarVen() {
		apagarVenComando.ejecutar();
		ultimaAccion= prenderVenComando;
	}
	
	public void pressPrenderAire() { //Acciones del aire acondicionado
		prenderAireComando.ejecutar();
		ultimaAccion= prenderAireComando;
	}
	public void pressApagarAire() {
		apagarAireComando.ejecutar();
		ultimaAccion= prenderAireComando;
	}
	public void deshacer() {
        if (ultimaAccion != null) {
            ultimaAccion.deshacer();
            ultimaAccion = null; // Limpiar la última acción después de deshacerla
        } else {
            System.out.println("No hay ninguna acción para deshacer.");
        }
    }
	
}

public class Main_D {
	public static void main(String [] args) {
		Luz luz = new Luz();
		Command prenderL = new EncenderLuzComando(luz);
		Command apagarL = new ApagarLuzComando(luz);
		
		Ventilador vent=new Ventilador();
		Command prenderV = new EncenderVenComando(vent);
		Command apagarV = new ApagarVenComando(vent);
		
		Aire aire = new Aire();
		Command prenderA = new EncenderAireComando(aire);
		Command apagarA = new ApagarAireComando(aire);
		
		ControlRemoto control = new ControlRemoto();
		control.setPrenderLuzComando(prenderL);
		control.setPrenderAireComando(prenderA);
		control.setPrenderLVenComando(prenderV);
		
		control.setApagarLuzComando(apagarL);
		control.setApagarVenComando(apagarV);
		control.setApagarAireComando(apagarA);
		
		control.pressPrenderLuz();
        control.pressPrenderVen();
        control.pressPrenderAire();

        // Deshacer la última acción
        control.deshacer(); // Deshace la acción de encender el aire acondicionado

        control.pressApagarLuz();  // Apaga la luz
        control.deshacer(); // Deshace la acción de apagar la luz
		
		
	}
}

package Pera_S;
import java.util.*;

public class Rectangulo {
	private Coordenada esquina1;
	private Coordenada esquina2;
	
	private double area;
	private double distancia;
	
	
	public Rectangulo(Coordenada c1, Coordenada c2) {
		setEsquina1(c1);
		setEsquina2(c2);
	}
	public void setEsquina1(Coordenada coo) {
		this.esquina1=coo;
	}
	
	public void setEsquina2(Coordenada coo) {
		this.esquina2=coo;
	}
	public Coordenada getEsquina1() {
		
		return this.esquina1;
	}
	
	public Coordenada getEsquina2() {
		
		return esquina2;
	}
	//Area
	public void setArea(double a) {
		this.area=a;
	}
	public double getArea() {
		
		return this.area;
	}
	
	//Distancia
	public void setDistancia(double d) {
		this.distancia=d;
	}
	
	public double getDistancia() {
		
		return this.distancia;
	}
	
	
	
	//metodo ToString (mostrar)
	public String toString() {
		
		if(esquina1.getX()>esquina2.getX()) {
			return "("+this.esquina2+", "+this.esquina1+")"; 
		}
		else {
			return "("+this.esquina1+", "+this.esquina2+")"; 
		}
	}
	
}

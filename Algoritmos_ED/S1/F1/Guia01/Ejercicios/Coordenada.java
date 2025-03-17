package Pera_S;
import java.util.*;
public class Coordenada {
	private double x;
	private double y;
	
	public Coordenada() {
		
	}
	
	public Coordenada(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double distancia (Coordenada C) {
		
		double restaX= this.getX()-C.getX();
		double restaY = this.getY()- C.getY();
		double distancia=Math.sqrt(Math.pow(restaX,2)+Math.pow(restaY, 2));
		
		return distancia;
	}
	
	public static double distancia(Coordenada c1, Coordenada c2) {
		
		double restaX= c1.getX()-c2.getX();
		double restaY = c1.getY()- c2.getY();
		double distancia=Math.sqrt(Math.pow(restaX,2)+Math.pow(restaY, 2));
		
		return distancia;
	}
	
	public String toString() {
		
		return "["+x +", "+y+"]";
	}
}

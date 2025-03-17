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
		return 0;
	}
	public static double distancia(Coordenada c1, Coordenada c2) {
		return 0;
	}
	
	public String toString() {
		
		return "["+x +", "+y+"]";
	}
}

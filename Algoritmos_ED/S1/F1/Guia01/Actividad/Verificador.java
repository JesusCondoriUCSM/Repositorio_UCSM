package Pera_S;
import java.util.*;

public class Verificador {
	public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
	    // Obtener los límites de r1
	    double r1MinX = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
	    double r1MaxX = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
	    double r1MinY = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
	    double r1MaxY = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());

	    // Obtener los límites de r2
	    double r2MinX = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
	    double r2MaxX = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
	    double r2MinY = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
	    double r2MaxY = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

	    // Verificar superposición en ambos ejes
	    boolean superposX = (r1MinX < r2MaxX) && (r1MaxX > r2MinX); 
	    boolean superposY = (r1MinY < r2MaxY) && (r1MaxY > r2MinY); 

	    return superposX && superposY;
	}

	
	public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
	    // Obtener los límites de r1
	    double r1MinX = Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX());
	    double r1MaxX = Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX());
	    double r1MinY = Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY());
	    double r1MaxY = Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY());

	    // Obtener los límites de r2
	    double r2MinX = Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX());
	    double r2MaxX = Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX());
	    double r2MinY = Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY());
	    double r2MaxY = Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY());

	    // Verificar si están juntos en el eje X
	    boolean juntoEnX = (r1MaxX == r2MinX || r1MinX == r2MaxX) &&
	                       (r1MaxY >= r2MinY && r1MinY <= r2MaxY);

	    // Verificar si están juntos en el eje Y
	    boolean juntoEnY = (r1MaxY == r2MinY || r1MinY == r2MaxY) &&
	                       (r1MaxX >= r2MinX && r1MinX <= r2MaxX);

	    return juntoEnX || juntoEnY;
	}

	
	public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
	    // Si no están superpuestos ni están juntos, son disjuntos
	    return !esSobrePos(r1, r2) && !esJunto(r1, r2);
	}
	
}

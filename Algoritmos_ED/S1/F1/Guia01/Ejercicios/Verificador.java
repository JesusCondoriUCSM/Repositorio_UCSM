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

	    // Verificar sobreposición en ambos ejes
	    boolean sobreposX = (r1MinX < r2MaxX) && (r1MaxX > r2MinX); 
	    boolean sobreposY = (r1MinY < r2MaxY) && (r1MaxY > r2MinY); 
	    
	    if (sobreposX && sobreposY) {
	    	System.out.println("Rectángulos A y B se sobreponen.");
	        // Calcular los límites de la intersección
	        double interseccionMinX = Math.max(r1MinX, r2MinX);
	        double interseccionMaxX = Math.min(r1MaxX, r2MaxX);
	        double interseccionMinY = Math.max(r1MinY, r2MinY);
	        double interseccionMaxY = Math.min(r1MaxY, r2MaxY);

	        // Calcular el área de la sobreposición
	        double ancho = interseccionMaxX - interseccionMinX;
	        double altura = interseccionMaxY - interseccionMinY;
	        double area = ancho * altura;

	        //Área de sobreposición
	        System.out.println("Área de sobreposición = " + area);
	        return true;
	    } else {
	        // No hay superposición
	        return false;
	    }
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

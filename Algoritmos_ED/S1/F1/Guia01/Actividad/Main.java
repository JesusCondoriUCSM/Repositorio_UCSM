package Pera_S;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Leer Rectángulo A
        System.out.println("Ingrese los datos del 1er rectángulo:");
        Rectangulo rectanguloA = leerRectangulo(sc);
        
        // Leer Rectángulo B
        System.out.println("Ingrese los datos del 2do rectángulo:");
        Rectangulo rectanguloB = leerRectangulo(sc);
        mostrar(rectanguloA,rectanguloB);
        // Relación entre los rectángulos
        if (Verificador.esSobrePos(rectanguloA, rectanguloB)) {
            
        } else if (Verificador.esJunto(rectanguloA, rectanguloB)) {
            System.out.println("Rectángulos A y B se juntan.");
        } else if (Verificador.esDisjunto(rectanguloA, rectanguloB)) {
            System.out.println("Rectángulos A y B son disjuntos.");
        }
        

    }
	
	public static Rectangulo leerRectangulo(Scanner sc) {
        System.out.print("Ingrese una esquina (x y):\n");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Ingrese la esquina opuesta (x y):\n");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        // Coordenadas en orden correcto
        Coordenada esquina1 = new Coordenada(Math.min(x1, x2), Math.min(y1, y2)); // Esquina con menor X y menor Y
        Coordenada esquina2 = new Coordenada(Math.max(x1, x2), Math.max(y1, y2)); // Esquina con mayor X y mayor Y

        return new Rectangulo(esquina1, esquina2);
    }
	
	public static void mostrar(Rectangulo rA, Rectangulo rB) {
		
		System.out.println("Rectangulo A = "+rA);
		System.out.println("Rectangulo B = "+rB);
		
	}
}

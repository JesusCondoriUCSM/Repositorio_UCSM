package Pera_S;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opc=0;
    	System.out.println("Capacidad de la lista: ");
    	int capa=sc.nextInt();
        
        ContainerRect contg= new ContainerRect(capa);
        while(opc!=3) {
        	System.out.println("Seleccione una opcion: \n");
        	System.out.println("1.Ingresar rectangulos \n2.Mostrar rectangulos \n3.Salir");
        	opc=sc.nextInt();
        	switch(opc){
        	case 1:
        		String let="";
        		while(!let.equalsIgnoreCase("n")) {
        			// Leer Rectángulo 
        	        System.out.println("Ingrese los datos del rectángulo:");
        	      
        	        AgregarDatosRect(contg,leerRectangulo(sc));
        	        
        	        System.out.println("Continuar ingresando? S/N");
        	        sc.nextLine();
        	        let=sc.nextLine();
        		}
        		break;
        	case 2:
        		System.out.println(contg);
        		break;
        		
        	case 3:
        		System.out.println("Saliendo del programa...");
        		break;
        	default:
        		System.out.println("Opción inválida. Intente de nuevo.");
        		
        	}
       
        }

    }
	
	//Ingresar datos al rectangulo
	public static Rectangulo leerRectangulo(Scanner sc) {
        System.out.print("Ingrese una esquina (x y):\n");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Ingrese la esquina opuesta (x y):\n");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        //Creacion de objetos tipo Coordenada
        return new Rectangulo(new Coordenada(Math.min(x1, x2), Math.min(y1, y2)), new Coordenada(Math.max(x1, x2), Math.max(y1, y2)));
    }
	
	//Mostrar
	public static void mostrar(Rectangulo rA, Rectangulo rB) {
		
		System.out.println("Rectangulo A = "+rA);
		System.out.println("Rectangulo B = "+rB);
		
	}
	
	//Calcular el área
	public static double calcularArea(Rectangulo r) {
		
		double base=0;
		double altura=0;
		
		if(r.getEsquina1().getX()>r.getEsquina2().getX()) {
			base=r.getEsquina1().getX()-r.getEsquina2().getX();
		}else {
			base=r.getEsquina2().getX()-r.getEsquina1().getX();
		}
		
		if(r.getEsquina1().getY()>r.getEsquina2().getY()) {
			altura=r.getEsquina1().getY()-r.getEsquina2().getY();
		}else {
			altura=r.getEsquina2().getY()-r.getEsquina1().getY();
		}
		return base*altura;
	}
	
	//Calcular la distancia
	
	public static double calcularDistancia(Coordenada c1, Coordenada c2) {
	    return Math.hypot(c1.getX() - c2.getX(), c1.getY() - c2.getY());
	}
	
	//Agregar datos a los arreglos
	
	public static void AgregarDatosRect(ContainerRect c,Rectangulo r) {
		double area=calcularArea(r);
        
        double distancia = calcularDistancia(r.getEsquina1(),r.getEsquina2());
        r.setArea(area);
        r.setDistancia(distancia);
        
		c.addRectangulo(r);
		c.addArea(r);
		c.addDistancia(r);
		
	}
}

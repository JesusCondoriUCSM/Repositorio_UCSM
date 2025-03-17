package Pera_S;

public class ContainerRect {
	private Rectangulo [] arregloRect;
	private double [] arregloDist;
	private double [] arregloArea;
	private int n;
	public static int numRec=0;
	
	public ContainerRect(int n) {
		this.n=n;
		this.arregloRect= new Rectangulo[n];
		this.arregloDist = new double[n];
		this.arregloArea = new double[n];
	}
	
	public void addRectangulo(Rectangulo r) {
		numRec+=1;
		if(numRec<=n) {
			arregloRect[numRec-1]=r;
		}
		else {
			System.out.println("No es posible guardar el rectángulo (Capacidad máxima)");
		}
	}
	
	public void addDistancia(Rectangulo r) {
		if(numRec<=n) {
			arregloDist[numRec-1]=r.getDistancia();
		}
		
	}
	
	public void addArea(Rectangulo r) {
		if(numRec<=n) {
			arregloArea[numRec-1]=r.getArea();
		}
		
	}
	
	public String toString() {
		String texto="";
		System.out.println("Rectángulo           Coordenadas                  Distancia                Área");
		for(int x=1;x<=numRec;x++) {
			String convertx=String.valueOf(x);
			String convertD=String.valueOf(arregloDist[x-1]);
			String convertA=String.valueOf(arregloArea[x-1]);
			texto+="    "+convertx+"         " + arregloRect[x-1]+"     " + convertD +"             " +convertA + "\n" ;
		}
		return texto;
	}
}

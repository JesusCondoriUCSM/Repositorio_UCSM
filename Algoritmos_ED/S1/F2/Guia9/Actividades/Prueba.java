package graph;
import ListLinked.ListLinked;
public class Prueba {
	public static void main(String [] args) {
		GraphLink<Integer> grafico= new GraphLink<>();
		grafico.insertVertex(1);
		grafico.insertVertex(2);
		grafico.insertVertex(3);
		grafico.insertVertex(4);
		
		grafico.insertEdge(1, 2);
		
		System.out.println("Grafo:");
		System.out.println(grafico.toString());

		
	}
}

package graph;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class PruebaObj {
    public static void main(String[] args) {
        // Crear un grafo simple (sin pesos, sin aristas múltiples)
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        
        // Agregar vértices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        
        // Agregar aristas
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        
        // Recorrido BFS desde vértice "A"
        BreadthFirstIterator<String, DefaultEdge> bfsIterator = new BreadthFirstIterator<>(graph, "A");
        
        System.out.println("Recorrido BFS:");
        while (bfsIterator.hasNext()) {
            System.out.println(bfsIterator.next());
        }
    }
}

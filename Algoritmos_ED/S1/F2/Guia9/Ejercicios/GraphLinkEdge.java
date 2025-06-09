package graph;
import java.util.*;
import Queue.LinkedQueue;

public class GraphListEdge<V,E> {
	ArrayList<VertexObj<V,E>> secVertex;
	ArrayList<EdgeObj<V,E>> secEdge;
	
	public GraphListEdge(){
		this.secVertex = new ArrayList<VertexObj<V,E>>();
		this.secEdge = new ArrayList<EdgeObj<V,E>>();
	}
	
	public void insertVertex(V data) { //Insertar vertice
	    VertexObj<V, E> nuevo = new VertexObj<>(data, secVertex.size());

	    if (secVertex.contains(nuevo)) {
	        System.out.println("Dato ya existente");
	    } else {
	        secVertex.add(nuevo);
	        System.out.println("Vértice insertado: " + data);
	    }
	}
	
	public void insertEdge(V v, V z) { //Insertar una arista
	    VertexObj<V, E> vert1 = null;
	    VertexObj<V, E> vert2 = null;

	    // Buscar los vértices en secVertex
	    for (VertexObj<V, E> vertex : secVertex) {
	        if (vertex.info.equals(v)) {
	            vert1 = vertex;
	        } else if (vertex.info.equals(z)) {
	            vert2 = vertex;
	        }
	    }

	    if (vert1 == null || vert2 == null) {
	        System.out.println("Uno o ambos vértices no existen.");
	        return;
	    }

	    // Verificar si la arista ya existe
	    for (EdgeObj<V, E> edge : secEdge) {
	        if ((edge.endVertex1.equals(vert1) && edge.endVertex2.equals(vert2)) ||
	            (edge.endVertex1.equals(vert2) && edge.endVertex2.equals(vert1))) {
	            System.out.println("La arista ya existe.");
	            return;
	        }
	    }

	    // Crear e insertar la nueva arista (sin peso)
	    EdgeObj<V, E> newEdge = new EdgeObj<>(vert1, vert2, null, secEdge.size());
	    secEdge.add(newEdge);
	    System.out.println("Arista insertada entre " + v + " y " + z);
	}
	
	public boolean searchVertex(V v) { //Busca el vertice
	    for (VertexObj<V, E> vertex : secVertex) {
	        if (vertex.info.equals(v)) {
	            return true;
	        }
	    }
	    return false;
	}

	public boolean searchEdge(V v, V z) { //Busca la arista
	    VertexObj<V, E> vert1 = null;
	    VertexObj<V, E> vert2 = null;

	    // Buscar los vértices en la lista
	    for (VertexObj<V, E> vert : secVertex) {
	        if (vert.info.equals(v)) vert1 = vert;
	        if (vert.info.equals(z)) vert2 = vert;
	    }

	    if (vert1 == null || vert2 == null) {
	        return false; // Uno o ambos vértices no existen
	    }

	    // Buscar la arista entre vert1 y vert2
	    for (EdgeObj<V, E> edge : secEdge) {
	        if ((edge.endVertex1.equals(vert1) && edge.endVertex2.equals(vert2)) ||
	            (edge.endVertex1.equals(vert2) && edge.endVertex2.equals(vert1))) {
	            return true;
	        }
	    }

	    return false;
	}
	
	public void bfs(V v) { //Recorrido por profundidad
	    // Buscar el vértice de inicio
	    VertexObj<V, E> start = null;
	    for (VertexObj<V, E> vert : secVertex) {
	        if (vert.info.equals(v)) {
	            start = vert;
	            break;
	        }
	    }

	    if (start == null) {
	        System.out.println("El vértice de inicio no existe.");
	        return;
	    }

	    // Mapa para llevar registro de los visitados
	    HashMap<VertexObj<V, E>, Boolean> visitado = new HashMap<>();
	    for (VertexObj<V, E> vert : secVertex) {
	        visitado.put(vert, false);
	    }

	    LinkedQueue<VertexObj<V, E>> cola = new LinkedQueue<>();
	    cola.enqueue(start);
	    visitado.put(start, true);

	    while (!cola.isEmpty()) {
	        VertexObj<V, E> actual = cola.dequeue();
	        System.out.println(actual.info); // Mostrar el vértice visitado

	        // Buscar adyacentes (vecinos)
	        for (EdgeObj<V, E> edge : secEdge) {
	            VertexObj<V, E> vecino = null;

	            // Si actual es un extremo, obtener el otro
	            if (edge.endVertex1.equals(actual)) {
	                vecino = edge.endVertex2;
	            } else if (edge.endVertex2.equals(actual)) {
	                vecino = edge.endVertex1;
	            }

	            if (vecino != null && !visitado.get(vecino)) {
	                cola.enqueue(vecino);
	                visitado.put(vecino, true);
	            }
	        }
	    }
	    
	}


	
}

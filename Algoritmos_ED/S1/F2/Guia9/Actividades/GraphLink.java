package graph;
import ListLinked.ListLinked;
import ListLinked.Node;
import java.util.*;
import Queue.LinkedQueue;
import Stack.LinkedStack;


public class GraphLink<E> {
	protected ListLinked <Vertex<E>> listVertex;
	
	public GraphLink() {
		listVertex= new ListLinked<Vertex<E>>();
	}
	
	public void insertVertex(E data) { //INSERTAR VERTICE
		
		
		Vertex<E> nuevo = new Vertex<>(data);
		
		if(listVertex.search(nuevo)==null) { //Verifica si existe ya un vertice con el mismo dato
			listVertex.insertar(nuevo);
		}
		
	}
	public void insertEdge(E verOri, E verDes) { //INSERTAR ARISTA
		
		//Crear vertices temporales para busqueda
		Vertex<E> vOri = new Vertex<>(verOri);
		Vertex<E> vDes = new Vertex<>(verDes);

		//Buscar nodos realees en la lista
		Node<Vertex<E>> nodeOri=listVertex.search(vOri);
		Node<Vertex<E>> nodeDes=listVertex.search(vDes);
		
		//Verificar si ambos vertices existen
		if(nodeOri==null || nodeDes==null) {
			System.out.println("Uno o ambos vertices no existen");
			return;
		}
		
		Vertex<E> realOri = nodeOri.getData();
		Vertex<E> realDes= nodeDes.getData();
		
		//Crear arista desde origen hacia destino
		Edge<E> edge = new Edge<>(realDes);
		
		//Insertar arista en la lista de adyacencia del origen
		realOri.listAdj.insertar(edge);
		
	}
	
	public boolean searchVertex(E v) { //BUSCA EL VERTICE v
		Vertex<E> buscar= new Vertex<>(v);
		
		Node<Vertex<E>> buscarNodo= listVertex.search(buscar);
		if(buscarNodo==null) {
			System.out.println("El vertice no existe");
			return false;
		}
		return true;
	}
	
	public boolean searchEdge(E v, E z) { //BUSCA LA ARISTA ENTRE VERTICES
		Vertex<E> ver1 = new Vertex<>(v);
		Vertex<E> ver2 = new Vertex<>(z);

		//Buscar nodos reales en la lista
		Node<Vertex<E>> nodeOri=listVertex.search(ver1);
		Node<Vertex<E>> nodeDes=listVertex.search(ver2);
		
		//Verificar si el vertice origen existe
		if(nodeOri!=null && nodeDes!=null) {
			Vertex<E> realOri=nodeOri.getData();
			Vertex<E> realDes=nodeDes.getData();
			
			Edge<E> refD=new Edge<>(realDes);
			
			if(realOri.listAdj.search(refD)!=null) {
				return true;
			}
		}
		return false;
		
		
	}
	
	public void removeVertex(E v) { //ELIMINA EL VERTICE V //NO DEJAR ARISTAS DE ENTRADA Y/O SALIDA DEL VERTICE
		Vertex<E> ver=new Vertex<>(v);
		Node<Vertex<E>> refVert=listVertex.search(ver);
		
		if(refVert==null) {
			System.out.println("Vertice inexistente");
			return;
		}
		else {
			Node<Vertex<E>> aux=listVertex.getRoot();
			
			Vertex<E> realVert=refVert.getData();
			
			Edge<E> refDest=new Edge<>(realVert);
			
			while(aux!=null) {
				
				if(aux.getData().listAdj.search(refDest)!=null){
					aux.getData().listAdj.eliminar(refDest);
				}
				
				aux=aux.getNext();
			}
			listVertex.eliminar(realVert);
		}
		
	}
	
	public void removeEdge(E v, E z) { //ELIMINA LA ARISTA ENTRE VERTICES
		Vertex<E> verOri=new Vertex<>(v);
		Vertex<E> verDest= new Vertex<>(z);
		
		
		
		Node<Vertex<E>> nodoOri=listVertex.search(verOri);
		Node<Vertex<E>> nodoDest= listVertex.search(verDest);
		
		if(nodoOri==null || nodoDest==null) {
			System.out.println("No existe uno o ambos vertices");
			return;
		}
		else {
			
			Vertex<E> realOri=nodoOri.getData();
			Vertex<E> realDest = nodoDest.getData();
			
			Edge<E> refDest= new Edge<>(realDest);
			
			realOri.listAdj.eliminar(refDest);
			
		}
		
	}
	
	public void dfs(E v) { //Recorrido por profundidad
	    Vertex<E> temp = new Vertex<>(v);
	    Node<Vertex<E>> nodo = listVertex.search(temp);

	    if (nodo == null) {
	        System.out.println("Vértice no encontrado");
	        return;
	    }

	    clearVisitados(); // Limpiar antes del recorrido
	    dfsRec(nodo.getData());
	}

	private void dfsRec(Vertex<E> v) {
	    v.setVisitado(true);
	    System.out.println(v.getData());

	    Node<Edge<E>> aux = v.listAdj.getRoot();
	    while (aux != null) {
	        Vertex<E> destino = aux.getData().getDestino();
	        if (!destino.isVisitado()) {
	            dfsRec(destino);
	        }
	        aux = aux.getNext();
	    }
	}

	private void clearVisitados() {
	    Node<Vertex<E>> aux = listVertex.getRoot();
	    while (aux != null) {
	        aux.getData().setVisitado(false);
	        aux = aux.getNext();
	    }
	}

	
	public void bfs(E v) { //Recorrido por anchura
	    Vertex<E> temp = new Vertex<>(v);
	    Node<Vertex<E>> nodo = listVertex.search(temp);

	    if (nodo == null) {
	        System.out.println("Vértice no encontrado");
	        return;
	    }

	    clearVisitados();  // Limpiar el estado de visitado antes de comenzar

	    LinkedQueue<Vertex<E>> queue = new LinkedQueue<>();
	    Vertex<E> start = nodo.getData();

	    start.setVisitado(true);
	    queue.enqueue(start);

	    while (!queue.isEmpty()) {
	        Vertex<E> current = queue.dequeue();
	        System.out.println(current.getData());

	        Node<Edge<E>> aux = current.listAdj.getRoot();
	        while (aux != null) {
	            Vertex<E> dest = aux.getData().getDestino();
	            if (!dest.isVisitado()) {
	                dest.setVisitado(true);
	                queue.enqueue(dest);
	            }
	            aux = aux.getNext();
	        }
	    }
	}

	
	
	public ArrayList<E> bfsPath(E v, E z) { //Secuencia de vertices entre los vertices v y z
	    ArrayList<E> camino = new ArrayList<>();

	    Vertex<E> tempV = new Vertex<>(v);
	    Vertex<E> tempZ = new Vertex<>(z);

	    Node<Vertex<E>> nodoV = listVertex.search(tempV);
	    Node<Vertex<E>> nodoZ = listVertex.search(tempZ);

	    if (nodoV == null || nodoZ == null) {
	        System.out.println("Uno o ambos vértices no existen");
	        return camino;
	    }

	    clearVisitados();

	    LinkedQueue<Vertex<E>> queue = new LinkedQueue<>();
	    Vertex<E> start = nodoV.getData();
	    Vertex<E> goal = nodoZ.getData();

	    HashMap<Vertex<E>, Vertex<E>> padres = new HashMap<>();

	    start.setVisitado(true);
	    queue.enqueue(start);
	    padres.put(start, null);

	    boolean encontrado = false;

	    while (!queue.isEmpty()) {
	        Vertex<E> current = queue.dequeue();

	        if (current.equals(goal)) {
	            encontrado = true;
	            break;
	        }

	        Node<Edge<E>> aux = current.listAdj.getRoot();
	        while (aux != null) {
	            Vertex<E> dest = aux.getData().getDestino();
	            if (!dest.isVisitado()) {
	                dest.setVisitado(true);
	                queue.enqueue(dest);
	                padres.put(dest, current);
	            }
	            aux = aux.getNext();
	        }
	    }

	    if (!encontrado) {
	        System.out.println("No existe camino entre " + v + " y " + z);
	        return camino;
	    }

	    LinkedStack<E> stack = new LinkedStack<>();

	    Vertex<E> iter = goal;
	    while (iter != null) {
	        stack.push(iter.getData());
	        iter = padres.get(iter);
	    }

	    while (!stack.isEmpty()) {
	        camino.add(stack.pop());
	    }

	    return camino;
	}

	
	public void insertEdgeWeight(E v, E z, int w) { //Insertar arista con peso

	    Vertex<E> verOri = new Vertex<>(v);
	    Vertex<E> verDest = new Vertex<>(z);

	    Node<Vertex<E>> nodoOri = listVertex.search(verOri);
	    Node<Vertex<E>> nodoDest = listVertex.search(verDest);

	    if (nodoOri == null || nodoDest == null) {
	        System.out.println("Uno o ambos vértices no existen");
	        return;
	    }

	    Vertex<E> realOri = nodoOri.getData();
	    Vertex<E> realDest = nodoDest.getData();

	    // Crear arista con peso
	    Edge<E> edge = new Edge<>(realDest, w);

	    // Insertar la arista en la lista de adyacencia del vértice origen
	    realOri.listAdj.insertar(edge);
	}

	

	public ArrayList<E> shortPath(E v, E z) { //Ruta mas corta y lo retorna en un arraylist
	    ArrayList<E> camino = new ArrayList<>();

	    Vertex<E> startV = new Vertex<>(v);
	    Vertex<E> endV = new Vertex<>(z);

	    Node<Vertex<E>> nodoStart = listVertex.search(startV);
	    Node<Vertex<E>> nodoEnd = listVertex.search(endV);

	    if (nodoStart == null || nodoEnd == null) {
	        System.out.println("Uno o ambos vértices no existen");
	        return camino;
	    }

	    Vertex<E> start = nodoStart.getData();
	    Vertex<E> end = nodoEnd.getData();

	    // Mapas para distancias y padres
	    HashMap<Vertex<E>, Integer> dist = new HashMap<>();
	    HashMap<Vertex<E>, Vertex<E>> padres = new HashMap<>();

	    // Inicializar distancias a infinito y padres a null
	    Node<Vertex<E>> aux = listVertex.getRoot();
	    while (aux != null) {
	        dist.put(aux.getData(), Integer.MAX_VALUE);
	        padres.put(aux.getData(), null);
	        aux = aux.getNext();
	    }

	    dist.put(start, 0);

	    // Cola prioridad para elegir el vértice con menor distancia
	    PriorityQueue<Vertex<E>> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

	    pq.add(start);

	    while (!pq.isEmpty()) {
	        Vertex<E> current = pq.poll();

	        if (current.equals(end)) {
	            break;  // Camino encontrado
	        }

	        Node<Edge<E>> ady = current.listAdj.getRoot();
	        while (ady != null) {
	            Vertex<E> vecino = ady.getData().getDestino();
	            int peso = ady.getData().getWeight(); // Necesitamos getter para weight en Edge

	            int nuevaDist = dist.get(current) + peso;
	            if (nuevaDist < dist.get(vecino)) {
	                dist.put(vecino, nuevaDist);
	                padres.put(vecino, current);

	                // Actualizar la prioridad
	                pq.add(vecino);
	            }
	            ady = ady.getNext();
	        }
	    }

	    // Reconstruir camino desde end hasta start usando padres
	    LinkedStack<E> stack = new LinkedStack<>();
	    Vertex<E> iter = end;

	    if (padres.get(iter) == null && !iter.equals(start)) {
	        System.out.println("No existe camino entre " + v + " y " + z);
	        return camino;
	    }

	    while (iter != null) {
	        stack.push(iter.getData());
	        iter = padres.get(iter);
	    }

	    while (!stack.isEmpty()) {
	        camino.add(stack.pop());
	    }

	    return camino;
	}


	
	public boolean isConexo() { //Comprueba si el grafo es conexo
	    if (listVertex.isEmpty()) return true;

	    clearVisitados(); // Marca todos como no visitados

	    // Obtener cualquier vértice de inicio
	    Vertex<E> inicio = listVertex.getRoot().getData();

	    // Ejecutar DFS desde el vértice de inicio
	    dfsRec(inicio);

	    // Verificar si todos fueron visitados
	    Node<Vertex<E>> aux = listVertex.getRoot();
	    while (aux != null) {
	        if (!aux.getData().isVisitado()) {
	            return false; // No conexo
	        }
	        aux = aux.getNext();
	    }

	    return true; // Conexo
	}

	
	public LinkedStack<E> dijsktra(E v, E z) { //retorna un stack con la ruta mas corta
	    HashMap<Vertex<E>, Integer> dist = new HashMap<>();
	    HashMap<Vertex<E>, Vertex<E>> prev = new HashMap<>();
	    ArrayList<Vertex<E>> vertices = new ArrayList<>();
	    clearVisitados();

	    // Inicialización
	    Node<Vertex<E>> aux = listVertex.getRoot();
	    Vertex<E> origen = null, destino = null;
	    
	    while (aux != null) {
	        Vertex<E> actual = aux.getData();
	        if (actual.getData().equals(v)) origen = actual;
	        if (actual.getData().equals(z)) destino = actual;
	        dist.put(actual, Integer.MAX_VALUE);
	        prev.put(actual, null);
	        vertices.add(actual);
	        aux = aux.getNext();
	    }

	    if (origen == null || destino == null) {
	        System.out.println("Uno o ambos vértices no existen");
	        return null;
	    }

	    dist.put(origen, 0);

	    while (!vertices.isEmpty()) {
	        // Elegir el vértice con menor distancia
	        Vertex<E> u = null;
	        int minDist = Integer.MAX_VALUE;
	        for (Vertex<E> vert : vertices) {
	            if (dist.get(vert) < minDist) {
	                minDist = dist.get(vert);
	                u = vert;
	            }
	        }

	        vertices.remove(u);
	        u.setVisitado(true);

	        Node<Edge<E>> adj = u.listAdj.getRoot();
	        while (adj != null) {
	            Vertex<E> vecino = adj.getData().getDestino();
	            int peso = adj.getData().getWeight();

	            if (!vecino.isVisitado() && dist.get(u) + peso < dist.get(vecino)) {
	                dist.put(vecino, dist.get(u) + peso);
	                prev.put(vecino, u);
	            }

	            adj = adj.getNext();
	        }
	    }

	    // Reconstruir el camino
	    LinkedStack<E> camino = new LinkedStack<>();
	    Vertex<E> paso = destino;

	    while (paso != null) {
	        camino.push(paso.getData());
	        paso = prev.get(paso);
	    }

	    // Si no hay camino, la cima de la pila no será el vértice origen
	    if (!camino.isEmpty() && !camino.top().equals(v)) {
	        System.out.println("No hay camino entre los vértices");
	        return new LinkedStack<>(); // Retorna pila vacía
	    }

	    return camino;
	}

	
	public String toString() {
		return this.listVertex.toString();
	}
}

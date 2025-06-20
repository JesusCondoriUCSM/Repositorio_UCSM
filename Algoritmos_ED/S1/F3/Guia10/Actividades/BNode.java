package btree;
import java.util.ArrayList;


public class BNode<E extends Comparable<E>> {
	private static int idCounter = 0;         // Contador global de nodos
    protected int idNode;                       // ID único del nodo actual
    protected ArrayList<E> keys;              // Lista de claves
    protected ArrayList<BNode<E>> childs;   // Lista de hijos
    protected int count;                      // Número actual de claves
    protected int order; 
    protected int idPadre = -1;
    
	public BNode(int orden) {
        this.order = orden;
        this.keys = new ArrayList<>(orden - 1);
        this.childs = new ArrayList<>(orden);
        this.count = 0;
        this.idNode = ++idCounter; // Asignar ID único al nodo

        // Inicializar claves y punteros a hijos
        for (int i = 0; i < order - 1; i++) {
            keys.add(null);
        }
        for (int i = 0; i < order; i++) {
            childs.add(null);
        }
    }
		//Check if the current node is full
	public boolean nodeFull(int maxKeys) {
	    return this.count == maxKeys;
	}


	//Check if the current node is empty
	public boolean nodeEmpty() {
	    return count == 0;
	}

	// Busca una clave en el nodo
	public boolean searchNode(E key, int[] pos) {
	    int i = 0;

	    // Recorrer claves válidas en orden
	    while (i < count && keys.get(i) != null && key.compareTo(keys.get(i)) > 0) {
	        i++;
	    }

	    // Si la clave es igual a alguna existente
	    if (i < count && keys.get(i) != null && key.compareTo(keys.get(i)) == 0) {
	        pos[0] = i;
	        return true; // Clave encontrada
	    }

	    // No se encontró la clave, pos indica el hijo donde continuar
	    pos[0] = i;
	    return false;
	}

	
    // Muestra las claves actuales del nodo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Node ID: " + idNode + " | Keys: [");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i));
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

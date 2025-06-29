package HashA;
import java.util.Iterator;
import java.util.LinkedList;

public class HashO {
	private LinkedList<Register>[] table;
	private int size;
	
	
	public HashO(int size) {
	    this.size = size;
	    table = new LinkedList[size];
	    for (int i = 0; i < size; i++) {
	        table[i] = new LinkedList<>();
	    }
	}

	
	private int hash(int key) {
		
		return key % size;
	}
	public void insert(Register reg) {
	    int index = hash(reg.getKey());
	    
	    // Verificar si ya existe un registro con la misma clave Y mismo nombre
	    for (Register r : table[index]) {
	        if (r.getKey() == reg.getKey() && r.getName().equals(reg.getName())) {
	            return; // Evita insertar si ya existe exactamente el mismo registro
	        }
	    }
	    
	    // Si no existe el mismo registro completo, agregar el nuevo registro
	    table[index].add(reg);
	}

	
	public Register search(int key) {
	    int index = hash(key);
	    for (Register r : table[index]) {
	        if (r.getKey() == key) {
	            return r;
	        }
	    }
	    return null; // No se encuentra el registro
	}

	
	public void delete(int key) {
	    int index = hash(key);
	    Iterator<Register> it = table[index].iterator();
	    while (it.hasNext()) {
	        Register r = it.next();
	        if (r.getKey() == key) {
	            it.remove(); // Eliminar el registro
	            return;
	        }
	    }
	}

	public void printTable() {
	    // Recorre todos los índices de la tabla
	    for (int i = 0; i < table.length; i++) {  // Asumiendo que 'table' es el array que contiene las listas
	        if (!table[i].isEmpty()) {  // Si la lista en el índice no está vacía
	            System.out.println("Índice " + i + " -> " + recorrer(i));
	        }
	    }
	}

	private String recorrer(int i) {
	    StringBuilder listaAcu = new StringBuilder();  // Usamos StringBuilder para eficiencia

	    for (int x = 0; x < table[i].size(); x++) {
	        listaAcu.append(table[i].get(x));  // Agrega el elemento actual a la cadena
	        if (x < table[i].size() - 1) {  // Si no es el último elemento, agrega una coma
	            listaAcu.append(", ");
	        }
	    }

	    return listaAcu.toString();  // Convertimos StringBuilder a String
	}


}

package Hash;

public class HashC {
	private static class Element {
		Register register;
		boolean isAvailable;
		
		public Element() {
			this.register=null;
			this.isAvailable=true;
		}
	}
	
	private Element[] table;
	private int size;
	
	public HashC(int size) {
		this.size=size;
		table=new Element[size];
	}
	
	private int hash(int key) {
		
		return key % size;
	}
	public void insert(Register reg) {
	    int index = hash(reg.getKey()); 
	    
	    // Manejo de colisiones usando sondeo lineal
	    while (table[index] != null && !table[index].isAvailable) {
	        index = (index + 1) % size; // Movimiento lineal al siguiente índice
	    }
	    
	    table[index] = new Element();
	    table[index].register = reg;
	    table[index].isAvailable = false; // Marca el lugar como ocupado
	}

	
	public Register search(int key) {
	    int index = hash(key);
	    while (table[index] != null) {
	        if (!table[index].isAvailable && table[index].register.getKey() == key) {
	            return table[index].register; // Si encontramos el registro
	        }
	        index = (index + 1) % size; // Sondeo lineal
	    }
	    return null; // Si no lo encontramos
	}

	public void delete(int key) {
	    int index = hash(key);
	    while (table[index] != null) {
	        if (!table[index].isAvailable && table[index].register.getKey() == key) {
	            table[index].isAvailable = true; // Marca como disponible el espacio
	            return;
	        }
	        index = (index + 1) % size;
	    }
	}

	public void printTable() {
	    for (int i = 0; i < size; i++) {
	        if (table[i] != null && !table[i].isAvailable) {
	            System.out.println("Índice " + i + ": " + table[i].register);
	        }
	    }
	}
}

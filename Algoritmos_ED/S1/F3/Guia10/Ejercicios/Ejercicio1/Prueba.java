import java.io.IOException;

import Exceptions.ItemNoFound;

public class Prueba {
	
public static void main(String[] args) {
    try {
        BTree<Integer> arbol = new BTree<>(4);
        arbol.building_BTree("C:\\Users\\condo\\eclipse-workspace\\TADB_TRE\\src\\btree\\arbol.txt");
        System.out.println(arbol);
    } catch (IOException | ItemNoFound e) {
        System.err.println("Error: " + e.getMessage());
    }
	}
}

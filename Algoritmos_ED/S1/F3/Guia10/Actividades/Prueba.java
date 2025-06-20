package btree;

public class Prueba {
	public static void main(String[] args) {
        // Crear árbol de orden 4 (máximo 3 claves por nodo)
        BTree<Integer> tree = new BTree<>(5);

        // Insertar claves 
        int[] values = {100, 50, 20, 70, 10, 30, 80, 90, 
        		200, 25, 15, 5, 65, 35, 60, 18, 93,94};

        for (int v : values) {
            tree.insert(v);
        }

        // Mostrar contenido del árbol en consola
        System.out.println(tree);
    }
}

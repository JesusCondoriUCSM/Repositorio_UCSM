import Exceptions.ItemNoFound;

public class Prueba {
    public static void main(String[] args) {
        // Crear árbol B de orden 4
        BTree<RegistroEstudiante> arbol = new BTree<>(4);

        // Insertar estudiantes
        arbol.insert(new RegistroEstudiante(103, "Ana"));
        arbol.insert(new RegistroEstudiante(110, "Luis"));
        arbol.insert(new RegistroEstudiante(101, "Carlos"));
        arbol.insert(new RegistroEstudiante(120, "Lucía"));
        arbol.insert(new RegistroEstudiante(115, "David"));
        arbol.insert(new RegistroEstudiante(125, "Jorge"));
        arbol.insert(new RegistroEstudiante(140, "Camila"));
        arbol.insert(new RegistroEstudiante(108, "Rosa"));
        arbol.insert(new RegistroEstudiante(132, "Ernesto"));
        arbol.insert(new RegistroEstudiante(128, "Denis"));
        arbol.insert(new RegistroEstudiante(145, "Enrique"));
        arbol.insert(new RegistroEstudiante(122, "Karina"));

        // Intentar insertar duplicado
        arbol.insert(new RegistroEstudiante(108, "Juan"));  // Duplicado

        System.out.println("\n------ Árbol luego de inserciones ------");
        System.out.println(arbol);

        // Búsquedas
        buscarNombre(arbol, 115); // → David
        buscarNombre(arbol, 132); // → Ernesto
        buscarNombre(arbol, 999); // → No encontrado

        // Eliminar estudiante con código 101
        arbol.remove(new RegistroEstudiante(101, ""));
        System.out.println("\n------ Árbol luego de eliminar 101 ------");
        System.out.println(arbol);

        // Insertar nuevo estudiante
        arbol.insert(new RegistroEstudiante(106, "Sara"));

        // Buscar nuevo insertado
        buscarNombre(arbol, 106); // → Sara

        System.out.println("\n------ Árbol final ------");
        System.out.println(arbol);
    }

    private static void buscarNombre(BTree<RegistroEstudiante> arbol, int codigo) {
        RegistroEstudiante resultado = arbol.buscarEstudiante(codigo);
        if (resultado != null) {
            System.out.println("Código " + codigo + " → " + resultado.getNombre());
        } else {
            System.out.println("Código " + codigo + " no encontrado.");
        }
    }
}

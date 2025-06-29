package HashA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prueba {
	public static void main(String[] args) {
        // Crear una nueva tabla hash con tamaño 3
        HashO hash1 = new HashO(11);

        // Crear los registros
        Register r1 = new Register(34, "Jesus");
        Register r2 = new Register(34, "Marta");
        Register r3 = new Register(34, "Mendez");
        Register r4 = new Register(30, "Juan");
        

        // Usar una lista para almacenar los registros
        List<Register> lista = new ArrayList<>(Arrays.asList(r1, r2, r3, r4));

        // Insertar los registros en la tabla hash
        for (Register reg : lista) {
            hash1.insert(reg);
        }

        // Imprimir la tabla para ver cómo quedó
        hash1.printTable();
        
        hash1.delete(34);
        
        hash1.printTable();
    }
}

package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        // Crear una nueva tabla hash con tamaño 3
        HashC hash1 = new HashC(11);

        // Crear los registros
        Register r1 = new Register(34, "Jesus");
        Register r2 = new Register(3, "Marta");
        Register r3 = new Register(7, "Mendez");
        Register r4 = new Register(30, "Juan");
        Register r5 = new Register(11, "Diego");
        Register r6 = new Register(8, "Armando");
        Register r7 = new Register(7, "Mariano");
        Register r8 = new Register(23, "Jose");
        Register r9 = new Register(41, "Alberto");
        Register r10 = new Register(16, "Matias");
        Register r11 = new Register(34, "Julian");

        // Usar una lista para almacenar los registros
        List<Register> lista = new ArrayList<>(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11));

        // Insertar los registros en la tabla hash
        for (Register reg : lista) {
            hash1.insert(reg);
        }

        // Imprimir la tabla para ver cómo quedó
        hash1.printTable();
        
        hash1.delete(30);
        hash1.printTable();
        
        System.out.println(hash1.search(23));
        
    }
}

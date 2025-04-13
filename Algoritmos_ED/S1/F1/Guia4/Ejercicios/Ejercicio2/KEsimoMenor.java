package Ejer2;

import java.util.Random;
import java.util.*;

public class KEsimoMenor {

    public static int encontrarKEsimoMenor(int[] arreglo, int k) {
        return quickSelect(arreglo, 0, arreglo.length - 1, k - 1); // k-1 porque usamos índices desde 0
    }

    public static int quickSelect(int[] arreglo, int izquierda, int derecha, int k) {
        if (izquierda == derecha) return arreglo[izquierda]; // Solo un elemento
        // Elegimos un pivote y partimos el arreglo
        int indicePivote = particionar(arreglo, izquierda, derecha); 

        // Si el pivote está en la posición k, lo encontramos
        if (k == indicePivote) {
            return arreglo[k];
        } else if (k < indicePivote) {
            return quickSelect(arreglo, izquierda, indicePivote - 1, k);
        } else {
            return quickSelect(arreglo, indicePivote + 1, derecha, k);
        }
    }

    public static int particionar(int[] arreglo, int izquierda, int derecha) {
        Random aleatorio = new Random(); //Mejorar la eficiencia
        int indicePivote = izquierda + aleatorio.nextInt(derecha - izquierda + 1);
        int valorPivote = arreglo[indicePivote];

        intercambiar(arreglo, indicePivote, derecha);

        int indiceAlmacen = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (arreglo[i] < valorPivote) {
                intercambiar(arreglo, indiceAlmacen, i);
                indiceAlmacen++;
            }
        }

        intercambiar(arreglo, indiceAlmacen, derecha);
        return indiceAlmacen;
    }

    public static void intercambiar(int[] arreglo, int i, int j) { //Intercambia los elementos 
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
        int[] arreglo = {7, 10, 4, 3, 20, 15,5};
        System.out.println("Nro del elemento mas pequeño: ");
        int k = sc.nextInt();
        
        int resultado = encontrarKEsimoMenor(arreglo, k);
        System.out.println("El " + k + "-ésimo menor elemento es: " + resultado);
        
    }
}

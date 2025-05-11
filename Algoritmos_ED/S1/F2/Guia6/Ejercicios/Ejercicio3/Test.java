package Guia6.Ejercicio.Ejercicio3;

import Guia6.Actividad.Actividad1.ExceptionIsEmpty;
import Guia6.Actividad.Actividad3.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> cola = new PriorityQueueLinked<>(4);
            cola.enqueue("A", 1);
            cola.enqueue("B", 1);
            cola.enqueue("C", 1);
            cola.enqueue("D", 4);
            cola.enqueue("E", 2);
            cola.enqueue("F", 3);

            System.out.println(cola.toString());

            cola.dequeue();
            System.out.println(cola.toString());

            System.out.println("Primer elemento: " + cola.front());
            System.out.println("Ultimo elemento: " + cola.back());
        }
        catch (ExceptionIsEmpty e) {
            System.out.println(e);
        }
    }
}

package Guia6.Ejercicio.Ejercicio2;
import Guia6.Actividad.Actividad1.ExceptionIsEmpty;
import Guia6.Actividad.Actividad2.Queue;

public class Test {
    public static void main(String[] args) {
        try {
            Queue<String> cola = new QueueArray<>(5);
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            cola.enqueue("D");
            cola.enqueue("E");
            System.out.println(cola.toString());

            System.out.println("Eliminando...");
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

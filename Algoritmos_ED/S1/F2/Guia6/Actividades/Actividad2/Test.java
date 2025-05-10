package Guia6.Actividad.Actividad2;
import Guia6.Actividad.Actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String [] args) {

        try {
            Queue<String> cola = new QueueLink<>();
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            System.out.println("Array: "+ cola.toString());

            //Elemento eliminado
            System.out.println("Elemento eliminado: "+cola.dequeue());
            System.out.println("Array: "+ cola.toString());

            //Primer elemento
            System.out.println("Primer elemento: "+cola.front());

            //Ultimo elemento
            System.out.println("Ulimo elemento: "+cola.back());

        }
        catch (ExceptionIsEmpty e) {
            System.out.println(e);
        }
    }
}

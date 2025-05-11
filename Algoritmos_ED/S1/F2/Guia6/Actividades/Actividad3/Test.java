package Guia6.Actividad.Actividad3;
import Guia6.Actividad.Actividad1.ExceptionIsEmpty;

public class Test {

    public static void main(String[] args) {
        try {
            PriorityQueue<String, Integer> queue = new PriorityQueueLinkSort<>();
            queue.enqueue("A", 1);
            queue.enqueue("B", 2);
            queue.enqueue("C", 3);
            queue.enqueue("D", 4);
            queue.enqueue("A", 1);
            System.out.println("Cola: " + queue.toString());

            queue.dequeue();
            System.out.println("Cola: " + queue.toString());

            System.out.println("Primer elemento: " + queue.front());
            System.out.println("Ultimo elemento: " + queue.back());
        } catch (ExceptionIsEmpty e) {
            System.out.println(e);
        }
    }
}

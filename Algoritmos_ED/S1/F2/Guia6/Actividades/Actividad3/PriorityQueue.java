package Guia6.Actividad.Actividad3;
import Guia6.Actividad.Actividad1.ExceptionIsEmpty;

public interface PriorityQueue <E,N>{
    void enqueue(E x, N pr);
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    E back() throws ExceptionIsEmpty;
    boolean isEmpty();
}

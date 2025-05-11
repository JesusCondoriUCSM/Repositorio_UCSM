package Guia6.Ejercicio.Ejercicio3;


import Guia6.Actividad.Actividad1.ExceptionIsEmpty;
import Guia6.Actividad.Actividad3.PriorityQueue;
import Guia6.Actividad.Actividad2.QueueLink;
public class PriorityQueueLinked <E,N > implements PriorityQueue<E,N> {

    private QueueLink<E>[] array_prioridad;
    private int niveles;

    public PriorityQueueLinked(int niveles) {
        this.niveles = niveles;
        array_prioridad = new QueueLink[niveles];
        for (int i = 0; i < niveles; i++) {
            array_prioridad[i] = new QueueLink<>();
        }
    }
    public void enqueue(E x, N pr){

        for(int i=0;i<niveles;i++){
            if(pr.equals(i+1)){
                array_prioridad[i].enqueue(x);
            }
        }

    }
    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < niveles; i++) {
            if (!array_prioridad[i].isEmpty()) {
                return array_prioridad[i].dequeue();
            }
        }
        return null;
    }
    public E front() throws ExceptionIsEmpty{
        for(int i=0;i<niveles;i++){
            if(!array_prioridad[i].isEmpty()){
                return array_prioridad[i].front();
            }
        }
        return null;
    }
    public E back() throws ExceptionIsEmpty{
        for(int i=niveles-1;i>=0;i--){
            if(!array_prioridad[i].isEmpty()){
                return array_prioridad[i].back();
            }
        }
        return null;
    }
    public boolean isEmpty(){
        for(int i=0;i<niveles;i++){
            if(!array_prioridad[i].isEmpty()){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String retor = "";
        for (int i = 0; i < niveles; i++) {
            retor +="Prioridad "+(i+1)+": "+ array_prioridad[i].toString();
            retor += "\n";
        }
        return retor;
    }
}

package Guia6.Actividad.Actividad2;
import Guia6.Actividad.Ejercicio1.Node;
import Guia6.Actividad.Actividad1.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink(){
        this.first = null;
        this.last = null;
    }
    public void enqueue(E x){
        Node<E> aux = new Node<E>(x);
        if (this.isEmpty()) {
            this.first = aux;
            this.last=aux;}
        else{
            this.last.setNext(aux);
            this.last = aux;
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Lista vacia");
        }
        else {
            E dato=first.getData();
            first=first.getNext();
            return dato;

        }
    }
    public E back() throws ExceptionIsEmpty {
        E dato=last.getData();
        return dato;
    }
    public E front() throws ExceptionIsEmpty {
        E dato=first.getData();
        return dato;
    }
    public boolean isEmpty() {
        return first==null;

    }

    public String toString(){

        Node<E> aux=first;
        if(isEmpty()) {
            System.out.println("Lista vacia");
        }
        String retorno="";
        while(aux!=null) {
            retorno+=aux.getData();
            retorno+=" ";
            aux=aux.getNext();
        }
        return retorno;

    }
}

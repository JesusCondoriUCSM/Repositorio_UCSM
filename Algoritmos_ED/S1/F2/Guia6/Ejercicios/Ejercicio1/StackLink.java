package Guia6.Ejercicio.Ejercicio1;

import Guia6.Actividad.Actividad1.ExceptionIsEmpty;
import Guia6.Actividad.Actividad1.Stack;

public class StackLink<E> implements Stack<E>{
    private Node <E> head;


    public StackLink() {
        this.head=null;
    }

    public void push(E x) {
        Node<E> nuevo = new Node<>(x);
        nuevo.setNext(head);
        head = nuevo;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Lista vacía");
        }
        E dato = head.getData();
        head = head.getNext();
        return dato;
    }

    public E top() throws ExceptionIsEmpty{
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Lista vacia");
        }
        E data=head.getData();
        return data;
    }
    public boolean isEmpty() {
        if(this.head==null) {
            return true;
        }
        return false;
    }

    public String toString() {
            Node <E> aux=head;
            String lista="";
            while(aux!=null) {
                lista+=aux.getData()+" ";
                aux=aux.getNext();
            }
            return lista;

    }
}

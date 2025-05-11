package Guia6.Ejercicio.Ejercicio1;

public class Node<E> {
    private E data;
    private Node <E> next;

    public Node(E d) {
        this.data=d;
        this.next=null;
    }

    public Node() {
        this.next=null;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E d) {
        this.data=d;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node <E> n) {
        this.next=n;
    }

    public String toString() {

        return "Dato: "+this.data;
    }
}

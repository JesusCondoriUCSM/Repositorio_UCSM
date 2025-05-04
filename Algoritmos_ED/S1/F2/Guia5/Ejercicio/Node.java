package Guia5.Ejercicio;

public class Node <T> {
    private T valor;
    private Node<T> siguiente;

    public Node(T valor){
        this.valor=valor;
        this.siguiente=null;
    }

    public Node(){
        this.siguiente=null;
    }

    public T getValor(){
        return this.valor;
    }

    public Node<T> getSiguiente(){
        return this.siguiente;
    }

    public void setSiguiente(Node<T> siguiente) {
        this.siguiente = siguiente;
    }
    public String toString(){
        return "Valor: " + this.getValor();
    }
}

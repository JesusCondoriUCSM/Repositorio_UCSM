package Guia5.Actividad;

public class Node <T>{
    T dato;
    Node <T> siguiente;

    public Node (T d){
        this.dato=d;
        this.siguiente=null;
    }
    public Node (){
        this.siguiente=null;
    }

    public T getDato(){
        return this.dato;
    }



}

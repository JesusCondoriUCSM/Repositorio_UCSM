package Guia6.Ejercicio.Ejercicio2;

import Guia6.Actividad.Actividad1.ExceptionIsEmpty;
import Guia6.Actividad.Actividad2.Queue;

public class QueueArray <E> implements Queue <E>{
    private E[] array;
    private int tamano;
    private int first;
    private int last;

    public QueueArray(int n){
        array=(E[]) new Object[n];
        tamano=n;
        first=-1;
        last=-1;
    }
    public void enqueue(E x){

        if(isEmpty()){
            first=0;
            last=0;
            array[first]=x;
        }else{
            last++;
            if(last==tamano){
                last--;
                System.out.println("Cola llena");
                return;
            }
            array[last]=x;

        }
    }
    public E dequeue() throws ExceptionIsEmpty{
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Lista vacia");
        }
        else{
            E data=array[first];
            array[first]=null;
            first++;
            return data;
        }
    }
    public E front() throws ExceptionIsEmpty{
        E data=array[first];
        return data;
    }
    public E back() throws ExceptionIsEmpty{
        E data=array[last];
        return data;
    }
    public boolean isEmpty(){
        if(first==-1){
            return true;
        }
        return false;
    }

    public String toString(){
        String cadena="Cola: [";
        for(int i=first;i<last;i++){
            cadena+=array[i]+", ";
        }
        cadena+=array[last]+"]";
        return cadena;
    }
}

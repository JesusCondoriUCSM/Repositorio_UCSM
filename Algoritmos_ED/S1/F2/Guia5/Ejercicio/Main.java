package Guia5.Ejercicio;

import static Guia5.Ejercicio.ListaEnlazada.*;
import static Guia5.Ejercicio.Lista.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        List<Integer> lista=new ArrayList<>();
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        verLista(lista);
        //Buscar un elemento generico en una lista
        System.out.println(buscarElemento(lista, 10));
        //Invertir una lista generica
        verLista(invertirLista(lista));

        Node<Integer> cabeza1 = null;
        cabeza1=insertarAlFinal(cabeza1,3);
        cabeza1=insertarAlFinal(cabeza1,4);
        cabeza1=insertarAlFinal(cabeza1,5);
        cabeza1=insertarAlFinal(cabeza1,6);

        Node<Integer> cabeza2 = null;
        cabeza2=insertarAlFinal(cabeza2,3);
        cabeza2=insertarAlFinal(cabeza2,4);
        cabeza2=insertarAlFinal(cabeza2,5);
        cabeza2=insertarAlFinal(cabeza2,6);
        //Contar nodos
        System.out.println(contarNodos(cabeza1));

        //Compara dos listas
        System.out.println(sonIguales(cabeza1, cabeza2));

        //Concatenar dos listas
        verLista(concatenarListas(cabeza1, cabeza2));
    }

}

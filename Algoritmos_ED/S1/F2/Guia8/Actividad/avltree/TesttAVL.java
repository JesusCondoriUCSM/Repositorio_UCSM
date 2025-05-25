package Guia8.Actividad.avltree;

import Guia8.Actividad.Exceptions.*;

public class TestAVL {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> arbol = new AVLTree<>();
            arbol.insert(2);
            arbol.insert(3);
            arbol.insert(4);
            arbol.insert(5);
            arbol.insert(6);
            arbol.insert(7);
            arbol.insert(8);
            arbol.insert(9);
            arbol.insert(1);
            arbol.insert(10);
            arbol.drawBST();
            System.out.println(arbol);

            System.out.println("Elemento encontrado: "+arbol.search(2)); //Buscar un elemento que no esta en el arbol
            System.out.println("Elemento encontrado: "+arbol.search(10));

            System.out.println("Altura del subarbol: "+arbol.height(9));
            System.out.println("Altura del subarbol: "+arbol.height(2));



        } catch (ItemDuplicated i) {
            System.out.println(i.getMessage());
        } catch (ItemNoFound item) {
            System.out.println(item.getMessage());
        }
    }
}

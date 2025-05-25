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
        } catch (ItemDuplicated i) {
            System.out.println(i);
        }
    }
}

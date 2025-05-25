package Guia8.Actividad.bstreeInterface;

import Guia8.Actividad.Exceptions.*;
import java.util.Stack;

public class LinkedBST <E extends Comparable<E>> implements BinarySearchTree<E>{
    public class Node{
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this(data,null,null);
        }
        public Node(E data, Node left, Node right) {
            this.data=data;
            this.left=left;
            this.right=right;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }

    }

    protected Node root;
    public LinkedBST() {
        this.root=null;
    }

    public Node getRaiz() {
        return this.root;
    }

    public void insert(E data) throws ItemDuplicated {
        Node nuevo= new Node(data);
        if(isEmpty()) {
            root=nuevo;
        }
        else {
            Node aux=root;
            while(aux!=null) {
                if(nuevo.data.compareTo(aux.data)>0) {
                    if(aux.right==null) {
                        aux.right=nuevo;
                        break;
                    }else {
                        aux=aux.right;
                    }

                }else if(nuevo.data.compareTo(aux.data)<0) {
                    if(aux.left==null) {
                        aux.left=nuevo;
                        break;
                    }else {
                        aux=aux.left;
                    }


                }else {
                    throw new ItemDuplicated("Valor del elemento ya existente");
                }

            }
        }
    }

    public void delete(E data) throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Árbol vacío");
        }
        root = deleteRecursive(root, data);
    }

    private Node deleteRecursive(Node node, E data) {
        if (node == null) {
            return null;
        }

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {
            node.left = deleteRecursive(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRecursive(node.right, data);
        } else {
            // Caso 1: sin hijos
            if (node.left == null && node.right == null) {
                return null;
            }
            // Caso 2: un hijo
            else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Caso 3: dos hijos
            else {
                // Encontrar el sucesor inorden (el menor del subárbol derecho)
                Node min = findMin(node.right);
                node.data = min.data;
                node.right = deleteRecursive(node.right, min.data);
            }
        }

        return node;
    }
    //Metodo auxiliar para encontrar el sucesor inorden
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


    public E search(E data) throws ItemNoFound {
        if (isEmpty()) {
            System.out.println("Árbol vacío");
            return null;
        }

        Node aux = root;

        while (aux != null) {
            if (aux.data.equals(data)) {
                return aux.data;
            } else if (data.compareTo(aux.data) < 0) {
                aux = aux.left;
            } else {
                aux = aux.right;
            }
        }

        throw new ItemNoFound("Elemento no encontrado");
    }








    //Verificar si esta vacio
    public boolean isEmpty() {
        if(root==null) return true;

        return false;
    }

    //InOrder
    public void inOrder() throws ExceptionIsEmpty {
        Node aux=this.root;
        this.inOrderRecursivo(aux);

    }
    //InOrder Recursivo

    private void inOrderRecursivo(Node aux) throws ExceptionIsEmpty {
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Arbol vacio");
        }
        else {
            if(aux==null) {

                return;
            }else {
                inOrderRecursivo(aux.left);
                System.out.println(aux.data);
                inOrderRecursivo(aux.right);
            }
        }

    }
    //PreOrder

    public void preOrder()  throws ExceptionIsEmpty{
        Node aux=root;
        this.preOrderRecursivo(aux);
    }
    //PreOrder Recursivo

    private void preOrderRecursivo(Node aux) throws ExceptionIsEmpty{
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Arbol vacio");
        }
        else {

            if( aux==null) {
                return;
            }else {
                System.out.println(aux.data);
                preOrderRecursivo(aux.left);
                preOrderRecursivo(aux.right);
            }
        }
    }



    //PostOrder
    public void postOrder()  throws ExceptionIsEmpty{
        Node aux=root;
        this.prostOrderRecursivo(aux);
    }

    //PostOrder Recursivo
    private void prostOrderRecursivo(Node aux) throws ExceptionIsEmpty{
        if(isEmpty()) {
            throw new ExceptionIsEmpty("Arbol vacio");
        }
        else {

            if( aux==null) {
                return;
            }else {
                preOrderRecursivo(aux.left);

                preOrderRecursivo(aux.right);

                System.out.println(aux.data);
            }
        }
    }

    //Menor valor del subarbol
    public E llamarMin(Node node) throws ItemNoFound {
        E data=findMinNode(node);
        return data;
    }
    private E findMinNode(Node node) throws ItemNoFound {

        if (node == null) {
            throw new ItemNoFound("Subárbol vacío, no se puede encontrar el mínimo.");
        }

        Node current = node;
        while (current.left != null) {
            current = current.left;
        }

        return search(current.data);
    }



    //Mayor valor del subárbol

    public E llamarMax(Node node) throws ItemNoFound {
        E data=findMaxNode(node);
        return data;
    }
    private E findMaxNode(Node node) throws ItemNoFound {
        if(node==null) {
            throw new ItemNoFound("Subárbol vacio, no se puede encontrar el maximo");
        }else {
            Node current = node;

            while(current.right!=null) {
                current=current.right;
            }

            return search(current.data);

        }
    }

    //METODOS EJERCICIOS
    //Destruir todos los nodos
    public void destroyNodes() {
        this.root=null;
    }

    //Numero total de nodos
    public int countAllNodes() {
        return countAllNodesRecursivo(root);
    }

    private int countAllNodesRecursivo(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countAllNodesRecursivo(node.left) + countAllNodesRecursivo(node.right);
    }


    //Numero de total de nodos no-hojas
    public int countNodes() {
        return countNodesRecursivo(root);
    }

    private int countNodesRecursivo(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 0; // Es hoja
        }

        // Es no-hoja, contar + hijos
        return 1 + countNodesRecursivo(node.left) + countNodesRecursivo(node.right);
    }


    //Altura del subárbol

    public int height(E x) {
        Node node = findNode(root, x); // Buscar el nodo con valor x
        if (node == null) {
            return -1; // No existe
        }

        return calculateHeightIterativo(node);
    }

    // Lógica para buscar un nodo con cierto valor
    private Node findNode(Node current, E x) {
        while (current != null) {
            if (x.equals(current.data)) {
                return current;
            } else if (x.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    // Cálculo iterativo de altura
    private int calculateHeightIterativo(Node node) {
        if (node == null) return -1;

        Queue<Node> queue = new Queue<>(); // Usa tu propia implementación
        queue.enqueue(node);
        int height = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++; // Subimos un nivel

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.dequeue();

                if (current.left != null) {
                    queue.enqueue(current.left);
                }
                if (current.right != null) {
                    queue.enqueue(current.right);
                }
            }
        }

        return height;
    }


    //Amplitud del arbol
    public int amplitude(int nivel) {
        if (nivel < 0 || root == null) {
            return 0;
        }

        int treeHeight = height(root.data); // usa altura total desde la raíz
        if (nivel > treeHeight) {
            return 0;
        }

        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            if (currentLevel == nivel) {
                return levelSize;
            }

            // Avanzar al siguiente nivel
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.dequeue();

                if (current.left != null) {
                    queue.enqueue(current.left);
                }

                if (current.right != null) {
                    queue.enqueue(current.right);
                }
            }

            currentLevel++;
        }

        return 0; // Nivel no existe
    }

    //Area del arbol
    public int areaBST() {
        if (root == null) {
            return 0; // Árbol vacío
        }

        int hojas = countLeavesIterativo();
        int altura = height(root.data); // Ya implementado antes

        return hojas * altura;
    }

    private int countLeavesIterativo() {
        if (root == null) return 0;

        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        int hojas = 0;

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();

            if (current.left == null && current.right == null) {
                hojas++;
            }

            if (current.left != null) {
                queue.enqueue(current.left);
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }

        return hojas;
    }




    //Dibujar
    public void drawBST() {
        drawBSTRecursive(root, 0);
    }

    private void drawBSTRecursive(Node node, int level) {
        if (node == null) {
            return;
        }

        drawBSTRecursive(node.right, level + 1); // mostrar primero la derecha

        // Mostrar el nodo actual con indentación
        for (int i = 0; i < level; i++) {
            System.out.print("    "); // 4 espacios por nivel
        }
        System.out.println(node.data.toString());

        drawBSTRecursive(node.left, level + 1); // luego la izquierda
    }

    // Método público que llama al método recursivo parenthesize
    public void parenthesize() {
        parenthesize(root, "");
    }

    // Método privado recursivo que imprime el nodo y sus hijos con indentación
    private void parenthesize(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.print(indent + node.data);

        // Si no tiene hijos, solo imprime el dato
        if (node.left == null && node.right == null) {
            System.out.println(); // salto de línea
            return;
        }

        System.out.println("("); // abre paréntesis y salto línea

        // Imprime hijo izquierdo con más indentación
        if (node.left != null) {
            parenthesize(node.left, indent + "    ");
        }

        // Imprime hijo derecho con más indentación
        if (node.right != null) {
            parenthesize(node.right, indent + "    ");
        }

        System.out.println(indent + ")"); // cierra paréntesis
    }



}


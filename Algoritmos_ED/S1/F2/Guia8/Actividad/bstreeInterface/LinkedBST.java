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
    }

    protected Node root;
    public LinkedBST() {
        this.root=null;
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


    /*@Override
    public String toString() {
        if (root == null) {
            return "Árbol vacío";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Recorrido inorden del BST:\n");
        sb.append("[");

        Stack<Node> stack = new Stack<>();
        Node current = root;
        boolean first = true;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (!first) {
                sb.append(", ");
            }
            sb.append(current.data);
            first = false;

            current = current.right;
        }

        sb.append("]");
        return sb.toString();
    }
*/





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
    private void prostOrderRecursivo(Node aux) throws ExceptionIsEmpty {
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
}

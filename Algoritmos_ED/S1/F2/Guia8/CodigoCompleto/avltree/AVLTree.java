package Guia8.Actividad.avltree;
import Guia8.Actividad.Exceptions.*;
import Guia8.Actividad.bstreeInterface.LinkedBST;
import Guia8.Actividad.bstreeInterface.Queue;

public class AVLTree <E extends Comparable<E>> extends LinkedBST<E> {

    class NodeAVL extends Node {
        protected int bf;

        public NodeAVL(E data) {
            super(data);

        }

        @Override
        public String toString() {
            return "Dato: " + data + "\nFactor de equlibrio:" + this.bf;
        }

    }

    private boolean height;

    public String toString(){
        return this.root.toString();
    }
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
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL) this.root);

    }

    protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;
        if (node == null) {
            this.height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);
            if (resC == 0) throw new ItemDuplicated(x + " ya se encuentra en el arbol");
            if (resC < 0) {
                fat.right = insert(x, (NodeAVL) node.right);
                if (this.height)
                    switch (fat.bf) {
                        case -1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            this.height = true;
                            break;
                        case 1:
                            //bf=2
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }

            } else {
                fat.left = insert(x, (NodeAVL) node.left);
                if (this.height)
                    switch (fat.bf) {
                        case 1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = -1;
                            this.height = true;
                            break;
                        case -1:
                            //bf=-2
                            fat = balanceToRight(fat);
                            this.height = false;
                            break;
                    }
            }
        }
        return fat;
    }
    public void delete(E x) throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Árbol vacío");
        this.height = false;
        this.root = delete((NodeAVL) this.root, x);
    }

    protected Node delete(NodeAVL node, E x) {
        if (node == null) return null;

        int resC = x.compareTo(node.data);

        if (resC < 0) {
            node.left = delete((NodeAVL) node.left, x);
            if (this.height)
                node = adjustBalanceRight(node);
        } else if (resC > 0) {
            node.right = delete((NodeAVL) node.right, x);
            if (this.height)
                node = adjustBalanceLeft(node);
        } else {
            if (node.left == null) {
                this.height = true;
                return node.right;
            } else if (node.right == null) {
                this.height = true;
                return node.left;
            } else {
                NodeAVL min = findMin((NodeAVL) node.right);
                node.data = min.data;
                node.right = delete((NodeAVL) node.right, min.data);
                if (this.height)
                    node = adjustBalanceLeft(node);
            }
        }
        return node;
    }

    private NodeAVL adjustBalanceRight(NodeAVL node) {
        switch (node.bf) {
            case -1: node.bf = 0; break;
            case 0: node.bf = 1; this.height = false; break;
            case 1:
                NodeAVL rightChild = (NodeAVL) node.right;
                int bf = rightChild.bf;
                if (bf >= 0) {
                    node = rotateSL(node);
                    if (bf == 0) {
                        node.bf = -1;
                        ((NodeAVL) node.left).bf = 1;
                        this.height = false;
                    } else {
                        node.bf = 0;
                        ((NodeAVL) node.left).bf = 0;
                    }
                } else {
                    node = balanceToLeft(node);
                }
                break;
        }
        return node;
    }

    private NodeAVL adjustBalanceLeft(NodeAVL node) {
        switch (node.bf) {
            case 1: node.bf = 0; break;
            case 0: node.bf = -1; this.height = false; break;
            case -1:
                NodeAVL leftChild = (NodeAVL) node.left;
                int bf = leftChild.bf;
                if (bf <= 0) {
                    node = rotateSR(node);
                    if (bf == 0) {
                        node.bf = 1;
                        ((NodeAVL) node.right).bf = -1;
                        this.height = false;
                    } else {
                        node.bf = 0;
                        ((NodeAVL) node.right).bf = 0;
                    }
                } else {
                    node = balanceToRight(node);
                }
                break;
        }
        return node;
    }

    private NodeAVL findMin(NodeAVL node) {
        while (node.left != null) {
            node = (NodeAVL) node.left;
        }
        return node;
    }
    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.right;
        switch (hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;

                node.right = rotateSR(hijo);
                node = rotateSL(node);
                break;
        }
        return node;

    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;
        switch (hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bf) {
                    case 1:
                        node.bf = 0;
                        hijo.bf = -1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case -1:
                        node.bf = -1;
                        hijo.bf = 0;
                        break;

                }
                nieto.bf = 0;

                node.left = rotateSL(hijo);
                node = rotateSR(node);
                break;
        }
        return node;
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }
    public void recorridoAmplitud() {
        if (root == null) return;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();
            System.out.println("Nivel " + level + ":");
            while (nodesAtCurrentLevel-- > 0) {
                Node current = queue.dequeue();
                System.out.println(" -> " + current.data);
                if (current.left != null) queue.enqueue(current.left);
                if (current.right != null) queue.enqueue(current.right);
            }
            level++;
        }
    }

}

package Guia8.Actividad.avltree;
import Guia8.Actividad.Exceptions.*;
import Guia8.Actividad.bstreeInterface.LinkedBST;

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


}

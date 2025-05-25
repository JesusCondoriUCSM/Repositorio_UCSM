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

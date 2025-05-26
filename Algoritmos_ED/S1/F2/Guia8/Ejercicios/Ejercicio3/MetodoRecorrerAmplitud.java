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

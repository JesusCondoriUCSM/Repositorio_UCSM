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

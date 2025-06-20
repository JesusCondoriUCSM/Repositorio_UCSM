public boolean search(E cl) {
	    return searchRecursive(this.root, cl);
	}

	private boolean searchRecursive(BNode<E> current, E cl) {
	    if (current == null) return false;

	    int i = 0;

	    // Buscar la posición donde debería estar o si ya está
	    while (i < current.count && cl.compareTo(current.keys.get(i)) > 0) {
	        i++;
	    }

	    // Si se encontró la clave
	    if (i < current.count && cl.compareTo(current.keys.get(i)) == 0) {
	        System.out.println(cl + " se encuentra en el nodo " + current.idNode + " en la posición " + i);
	        return true;
	    }

	    // Si es hoja y no está
	    if (current.childs.get(i) == null) return false;

	    // Continuar búsqueda en el hijo correspondiente
	    return searchRecursive(current.childs.get(i), cl);
	}

	public void remove(E cl) {
	    if (isEmpty()) {
	        System.out.println("El árbol está vacío.");
	        return;
	    }
	    delete(root, cl);

	    // Si la raíz se quedó sin claves y tiene un hijo, ese hijo se vuelve la nueva raíz
	    if (root.count == 0 && root.childs.get(0) != null) {
	        root = root.childs.get(0);
	    } else if (root.count == 0) {
	        root = null;
	    }
	}
	private void delete(BNode<E> node, E key) {
	    int idx = findKeyIndex(node, key);

	    if (idx < node.count && node.keys.get(idx).compareTo(key) == 0) {
	        if (node.childs.get(idx) == null) {
	            removeFromLeaf(node, idx);
	        } else {
	            removeFromInternal(node, idx);
	        }
	    } else {
	        if (node.childs.get(idx) == null) {
	            System.out.println("La clave " + key + " no se encuentra en el árbol.");
	            return;
	        }

	        boolean flag = (idx == node.count);

	        if (node.childs.get(idx).count < (orden / 2)) {
	            fill(node, idx);
	        }

	        if (flag && idx > node.count) {
	            delete(node.childs.get(idx - 1), key);
	        } else {
	            delete(node.childs.get(idx), key);
	        }
	    }
	}
	//Buscar índice de clave
	private int findKeyIndex(BNode<E> node, E key) {
	    int idx = 0;
	    while (idx < node.count && key.compareTo(node.keys.get(idx)) > 0) idx++;
	    return idx;
	}
	//Eliminar de hoja
	private void removeFromLeaf(BNode<E> node, int idx) {
	    for (int i = idx + 1; i < node.count; i++) {
	        node.keys.set(i - 1, node.keys.get(i));
	    }
	    node.keys.set(node.count - 1, null);
	    node.count--;
	}
	//Eliminar de nodo interno
	private void removeFromInternal(BNode<E> node, int idx) {
	    E k = node.keys.get(idx);
	    if (node.childs.get(idx).count >= (orden / 2)) {
	        E pred = getPredecessor(node, idx);
	        node.keys.set(idx, pred);
	        delete(node.childs.get(idx), pred);
	    } else if (node.childs.get(idx + 1).count >= (orden / 2)) {
	        E succ = getSuccessor(node, idx);
	        node.keys.set(idx, succ);
	        delete(node.childs.get(idx + 1), succ);
	    } else {
	        merge(node, idx);
	        delete(node.childs.get(idx), k);
	    }
	}
	
	//Obtener predecesor 
	private E getPredecessor(BNode<E> node, int idx) {
	    BNode<E> current = node.childs.get(idx);
	    while (current.childs.get(current.count) != null)
	        current = current.childs.get(current.count);
	    return current.keys.get(current.count - 1);
	}
	//Obtener sucesor
	private E getSuccessor(BNode<E> node, int idx) {
	    BNode<E> current = node.childs.get(idx + 1);
	    while (current.childs.get(0) != null)
	        current = current.childs.get(0);
	    return current.keys.get(0);
	}

	//Llenar nodo si tiene menos del mínimo
	private void fill(BNode<E> node, int idx) {
	    if (idx != 0 && node.childs.get(idx - 1).count >= (orden / 2)) {
	        borrowFromPrev(node, idx);
	    } else if (idx != node.count && node.childs.get(idx + 1).count >= (orden / 2)) {
	        borrowFromNext(node, idx);
	    } else {
	        if (idx != node.count) {
	            merge(node, idx);
	        } else {
	            merge(node, idx - 1);
	        }
	    }
	}
	//Redistribución hijo izquierdo
	private void borrowFromPrev(BNode<E> node, int idx) {
	    BNode<E> child = node.childs.get(idx);
	    BNode<E> sibling = node.childs.get(idx - 1);

	    for (int i = child.count - 1; i >= 0; i--)
	        child.keys.set(i + 1, child.keys.get(i));

	    if (child.childs.get(0) != null) {
	        for (int i = child.count; i >= 0; i--)
	            child.childs.set(i + 1, child.childs.get(i));
	    }

	    child.keys.set(0, node.keys.get(idx - 1));

	    if (child.childs.get(0) != null)
	        child.childs.set(0, sibling.childs.get(sibling.count));

	    node.keys.set(idx - 1, sibling.keys.get(sibling.count - 1));

	    sibling.keys.set(sibling.count - 1, null);
	    sibling.childs.set(sibling.count, null);
	    sibling.count--;
	    child.count++;
	}
	
	//Redistribución hijo derecho
	private void borrowFromNext(BNode<E> node, int idx) {
	    BNode<E> child = node.childs.get(idx);
	    BNode<E> sibling = node.childs.get(idx + 1);

	    child.keys.set(child.count, node.keys.get(idx));

	    if (child.childs.get(0) != null)
	        child.childs.set(child.count + 1, sibling.childs.get(0));

	    node.keys.set(idx, sibling.keys.get(0));

	    for (int i = 1; i < sibling.count; i++)
	        sibling.keys.set(i - 1, sibling.keys.get(i));

	    if (sibling.childs.get(0) != null) {
	        for (int i = 1; i <= sibling.count; i++)
	            sibling.childs.set(i - 1, sibling.childs.get(i));
	    }

	    sibling.keys.set(sibling.count - 1, null);
	    sibling.childs.set(sibling.count, null);
	    sibling.count--;
	    child.count++;
	}

	//Fusión de Nodos
	private void merge(BNode<E> node, int idx) {
	    BNode<E> child = node.childs.get(idx);
	    BNode<E> sibling = node.childs.get(idx + 1);

	    child.keys.set(orden / 2 - 1, node.keys.get(idx));

	    for (int i = 0; i < sibling.count; i++)
	        child.keys.set(i + orden / 2, sibling.keys.get(i));

	    for (int i = 0; i <= sibling.count; i++)
	        child.childs.set(i + orden / 2, sibling.childs.get(i));

	    for (int i = idx + 1; i < node.count; i++) {
	        node.keys.set(i - 1, node.keys.get(i));
	        node.childs.set(i, node.childs.get(i + 1));
	    }

	    node.keys.set(node.count - 1, null);
	    node.childs.set(node.count, null);

	    child.count += sibling.count + 1;
	    node.count--;
	}
	
	public BTree<E> building_BTree(String filePath) throws IOException, ItemNoFound {
	    List<String> lines = Files.readAllLines(Paths.get(filePath));
	    if (lines.isEmpty()) throw new ItemNoFound("Archivo vacío");

	    int orden = Integer.parseInt(lines.get(0).trim());
	    Map<Integer, BNode<E>> nodeMap = new HashMap<>();
	    Map<Integer, Integer> levelMap = new HashMap<>();

	    this.orden = orden;
	    this.root = null;

	    // Construir nodos
	    for (int i = 1; i < lines.size(); i++) {
	        String[] parts = lines.get(i).split(",");
	        int nivel = Integer.parseInt(parts[0]);
	        int idNode = Integer.parseInt(parts[1]);

	        BNode<E> node = new BNode<>(orden);
	        node.idNode = idNode;
	        node.count = parts.length - 2;

	        for (int j = 2; j < parts.length; j++) {
	            E key = (E) castToComparable(parts[j].trim());
	            node.keys.set(j - 2, key);
	        }

	        nodeMap.put(idNode, node);
	        levelMap.put(idNode, nivel);
	    }

	    // Establecer relaciones padre-hijo
	    for (int parentId : nodeMap.keySet()) {
	        int parentLevel = levelMap.get(parentId);
	        BNode<E> parent = nodeMap.get(parentId);

	        for (int childId : nodeMap.keySet()) {
	            if (levelMap.get(childId) == parentLevel + 1) {
	                BNode<E> child = nodeMap.get(childId);
	                if (isChildOf(parent, child)) {
	                    for (int i = 0; i <= parent.count; i++) {
	                        if (parent.childs.get(i) == null) {
	                            parent.childs.set(i, child);
	                            child.idPadre = parent.idNode;
	                            break;
	                        }
	                    }
	                }
	            }
	        }
	    }

	    // Encontrar la raíz (el nodo con el menor nivel)
	    int rootId = levelMap.entrySet().stream()
	        .min(Map.Entry.comparingByValue())
	        .orElseThrow(() -> new ItemNoFound("No se encontró raíz"))
	        .getKey();

	    this.root = nodeMap.get(rootId);
	    return this;
	}
	
	private Comparable<?> castToComparable(String value) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return value; // string u otro tipo
	    }
	}

	//Verificador de relación padre-hijo
	private boolean isChildOf(BNode<E> parent, BNode<E> child) {
	    E firstKey = child.keys.get(0);
	    E lastKey = child.keys.get(child.count - 1);

	    if (firstKey.compareTo(parent.keys.get(0)) <= 0) return true;
	    if (lastKey.compareTo(parent.keys.get(parent.count - 1)) > 0) return true;

	    for (int i = 0; i < parent.count - 1; i++) {
	        if (firstKey.compareTo(parent.keys.get(i)) > 0 && lastKey.compareTo(parent.keys.get(i + 1)) <= 0)
	            return true;
	    }
	    return false;
	}

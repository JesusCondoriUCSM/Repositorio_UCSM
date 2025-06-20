@SuppressWarnings("unchecked")
	public RegistroEstudiante buscarEstudiante(int codigo) {
	    RegistroEstudiante clave = new RegistroEstudiante(codigo, "");
	    return buscarEstudianteRec(root, clave);
	}

	@SuppressWarnings("unchecked")
	private RegistroEstudiante buscarEstudianteRec(BNode<E> node, RegistroEstudiante target) {
	    if (node == null) return null;

	    int i = 0;
	    while (i < node.count && target.compareTo((RegistroEstudiante) node.keys.get(i)) > 0) i++;

	    if (i < node.count && target.compareTo((RegistroEstudiante) node.keys.get(i)) == 0) {
	        System.out.println(target.getCodigo() + " se encuentra en el nodo " + node.idNode + " en la posición " + i);
	        return (RegistroEstudiante) node.keys.get(i);
	    }

	    if (node.childs.get(i) == null) return null;

	    return buscarEstudianteRec(node.childs.get(i), target);
	}

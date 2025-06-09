public class LinkedStack <E>{
	private Node <E>root;
	
	public LinkedStack() {
		this.root=null;
	}
	
	
	public void push(E dato) {
		Node<E> nuevo= new Node<>(dato);
		nuevo.setNext(root);
		root=nuevo;
	}
	
	public E pop() {
		
		if(isEmpty()) {
			System.out.println("Pila vacia");
			return null;
		}else {
			E dato=root.getData();
			root=root.getNext();
			return dato;

		}
			
		
	}
	public E top() {
		return root.getData(); 
	}
	
	
	
	
	public void recorrerLista() {
		if(isEmpty()) {
			System.out.println("Pila vacia");
		}else {
			Node<E> aux=root;
			
			while(aux!=null) {
				System.out.println(aux.getData());
				aux=aux.getNext();
			}
			
		}
		
	}
	
	public boolean isEmpty() {
		return this.root==null;
	}
}

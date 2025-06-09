package Queue;

import ListLinked.Node;

public class LinkedQueue<E> {
	
	private Node <E>root;
	private Node<E> last;
	
	public LinkedQueue() {
		this.root=null;
		this.last=null;
	}
	
	
	public void enqueue(E dato) {
	    Node<E> nuevo = new Node<>(dato);
	    if (isEmpty()) {
	        root = nuevo;
	        last = nuevo;
	    } else {
	        last.setNext(nuevo);
	        last = nuevo;
	    }
	}

	
	
	public E dequeue() {
		
		if(isEmpty()) {
			System.out.println("Cola vacia");
			return null;
		}else if(last==root) {
			E dato=root.getData();
			root=null;
			last=null;
			return dato;
		}
		
		else {
			
			E dato=root.getData();
			root=root.getNext();
			return dato;
		}
	}
	
	public E back() {
		if(isEmpty()) {
			System.out.println("Cola vacia");
			return null;
		}else {
			
			return last.getData();
		}
	}
	
	public E front() {
		if(isEmpty()) {
			System.out.println("Cola vacia");
			return null;
		}else {
			return this.root.getData();

		}
		
	}
	public void recorrerLista() {
		if(isEmpty()) {
			System.out.println("Cola vacia");
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

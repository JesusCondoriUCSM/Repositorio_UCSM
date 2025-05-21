package bstreeInterface;
import Exceptions.*;
public class Prueba {
	public static void main(String [] args) {
		try {
			LinkedBST<Integer> arbol = new LinkedBST<>();
			arbol.insert(2);
			arbol.insert(3);
			arbol.insert(4);
			arbol.insert(5);
			arbol.insert(6);
			arbol.insert(1);

			System.out.println(arbol.toString());
			
			arbol.delete(2);
			
			System.out.println(arbol.toString());
			
			
			System.out.println(arbol.search(4));
			
			//arbol.inOrder();
			//arbol.preOrder();
			//arbol.postOrder();
			
			LinkedBST<Integer> arbolPrueba = new LinkedBST<>();
			arbolPrueba.insert(3);
			arbolPrueba.insert(2);
			arbolPrueba.insert(1);
			arbolPrueba.insert(4);

			//Menor elemento del arbol creado, buscandolo en el arbol orginal
			System.out.println("Elemento encontrado: "+arbol.llamarMin(arbolPrueba.getRaiz()));
			
			//Mayor elemento del arbol creado, buscandolo en el arbol orginal
			System.out.println("Elemento encontrado: "+arbol.llamarMin(arbolPrueba.getRaiz()));
			

		}catch(ItemDuplicated i) {
			System.out.println(i);
		}catch(ExceptionIsEmpty e) {
			System.out.println(e);
		}catch(ItemNoFound item) {
			System.out.println(item);
		}
		
	}
}

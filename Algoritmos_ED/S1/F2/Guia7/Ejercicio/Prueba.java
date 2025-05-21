package bstreeInterface;
import Exceptions.*;
public class Prueba {
	
	 public static <E> boolean sameArea(LinkedBST arbol1, LinkedBST arbol2) {
	        return arbol1.areaBST() == arbol2.areaBST();
	 }
	 
	public static void main(String [] args) {
	    try {
	        LinkedBST<Integer> arbol = new LinkedBST<>();
	        arbol.insert(2);
	        arbol.insert(3);
	        arbol.insert(4);
	        arbol.insert(5);
	        arbol.insert(6);
	        arbol.insert(1);
	        
	        //Usando el parentesis
	        arbol.parenthesize();
	        
	        arbol.delete(2);

	        System.out.println(arbol.search(4));
	        
	        // Mostrar el árbol completo (dibujado en consola)
	        System.out.println("Árbol:\n");
	        arbol.drawBST();

	        LinkedBST<Integer> arbolPrueba = new LinkedBST<>();
	        arbolPrueba.insert(3);
	        arbolPrueba.insert(2);
	        arbolPrueba.insert(1);
	        arbolPrueba.insert(4);

	        // Mostrar el árbol arbolPrueba
	        System.out.println("Árbol:\n");
	        arbolPrueba.drawBST();
	        
	        //Son iguales
	        boolean iguales = sameArea(arbol, arbolPrueba);
            System.out.println("¿Misma área? " + iguales);
            
	        // Menor elemento del arbol creado, buscandolo en el arbol orginal
	        System.out.println("Elemento encontrado: " + arbol.llamarMin(arbolPrueba.getRaiz()));

	        // Mayor elemento del arbol creado, buscandolo en el arbol orginal
	        System.out.println("Elemento encontrado: " + arbol.llamarMax(arbolPrueba.getRaiz()));

	    } catch(ItemDuplicated i) {
	        System.out.println(i);
	    } catch(ExceptionIsEmpty e) {
	        System.out.println(e);
	    } catch(ItemNoFound item) {
	        System.out.println(item);
	    }
	}

}

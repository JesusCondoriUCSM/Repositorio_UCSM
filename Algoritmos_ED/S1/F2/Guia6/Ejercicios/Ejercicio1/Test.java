package ejercicio1;

import actividad1.ExceptionIsEmpty;
import actividad1.Stack;

public class Test {
public static void main(String args[]) {
	try {
		Stack <Integer> stack= new StackLink<>();
		stack.push(3);
		stack.push(5);
		stack.push(4);
		stack.push(7);
		stack.push(2);
		stack.push(8);
		stack.push(5);
		stack.push(3);
		stack.mostrar();
		System.out.println("Eliminando...");
		stack.pop(); //Elimina el ultimo ingresado
		stack.mostrar();
		
		System.out.println("Tope: "+stack.top()); //Tope de la pila
		
	} catch (ExceptionIsEmpty e) {
		System.out.println(e);
	}
}
}

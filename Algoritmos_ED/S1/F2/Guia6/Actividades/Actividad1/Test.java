package Guia6.Actividad.Actividad1;

public class Test {
    public static void main(String [] args) {
        try {
            Stack <Integer> stack= new StackArray<>(3);
            stack.push(3);
            stack.push(5);
            System.out.println("Array: "+stack.toString());

            System.out.println("Elemento eliminado: "+stack.pop());
            System.out.println("Array: "+stack.toString());

        } catch (ExceptionIsEmpty e) {
            System.out.println(e);
        }
    }
}

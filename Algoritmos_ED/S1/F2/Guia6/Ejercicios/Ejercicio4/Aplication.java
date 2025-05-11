package Guia6.Ejercicio.Ejercicio4;

import Guia6.Actividad.Actividad1.ExceptionIsEmpty;
import Guia6.Ejercicio.Ejercicio1.StackLink;

public class Aplication {

    public static boolean symbolBalancing(String s) {
        StackLink<Character> stack = new StackLink<>();

        try {
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    if (stack.isEmpty()) return false;

                    char top = stack.pop();
                    if (!matches(top, c)) return false;
                }
            }

            return stack.isEmpty();
        } catch (ExceptionIsEmpty e) {
            // No debería ocurrir, pero lo capturamos por seguridad
            return false;
        }
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        System.out.println(symbolBalancing("()()[()]"));  // true
        System.out.println(symbolBalancing("[(()]"));     // false
        System.out.println(symbolBalancing("{[()]}"));    // true
        System.out.println(symbolBalancing("([)]"));      // false
    }
}

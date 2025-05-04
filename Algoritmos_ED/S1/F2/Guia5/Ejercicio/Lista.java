package Guia5.Ejercicio;
import java.util.ArrayList;
import java.util.List;
public class Lista {

    //Buscar un elemento generico en una lista
    public static <T> boolean buscarElemento(List<T> lista,T valor){
        for(T value : lista){
            if(value.equals(valor)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    //Invertir una lista generica
    public static <T> List<T> invertirLista(List<T> lista) {
        List<T> listaTempo = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            listaTempo.add(lista.get(i));
        }
        return listaTempo;
    }


    public static <T> void verLista(List<T> lista){
        for(T value : lista){
           System.out.println(value);
        }
    }
}

package Guia5.Actividad;
import java.util.ArrayList;
import java.util.List;
public class GestorTareas <T >{
    private Node <T> cabecera;
    private List <T> tareas;

    GestorTareas(){
        this.tareas=new ArrayList<>();
        this.cabecera=null;
    }

    //Agrega tarea al final
    public void agregarTarea(T tarea){
        Node <T> nuevo = new Node<>(tarea);
        if(cabecera == null){
            cabecera=nuevo;
        }else{
            Node <T> aux = cabecera;
            while(aux.siguiente!=null){
                aux=aux.siguiente;
            }
            aux.siguiente=nuevo;
        }
    }
    //Eliminar tarea
    public boolean eliminarTarea(T tarea){
        Node<T> aux=cabecera;
        if(estaVacia()){
            return false;
        }
        if(cabecera.dato.equals(tarea)){
            cabecera=aux.siguiente;
            System.out.println("Tarea eliminada");
            return true;
        } else{

            while(aux!=null){
                if(aux.siguiente.dato.equals(tarea)){
                    aux.siguiente=aux.siguiente.siguiente;
                    return true;
                }
                aux=aux.siguiente;
            }
            return false;
        }

    }
    //Encontrar una tarea
    public boolean buscaTarea(T tarea){
        Node <T> aux=cabecera;
        if(estaVacia()){
            return false;
        }else{
            while (aux!=null){

                if(aux.getDato().equals(tarea)){
                    System.out.println("Tarea existente");
                    return true;
                }
            aux=aux.siguiente;
            }
            System.out.println("Tarea no encontrada");
            return false;
        }

    }
    //Cuenta tareas
    public int contarTareas(){
        int contador=0;
        if(estaVacia()){
            return 0;
        }
        else{
            Node <T> aux=cabecera;
            while(aux!=null){
               contador+=1;
               aux=aux.siguiente;
            }
            return contador;
        }
    }
    //Tareas mas prioritaria
    public T obtenerTareaMasPrioritaria() {
        if (estaVacia()) {
            return null;
        } else {
            Node<T> aux = cabecera;
            Node<T> tempo = null;
            int mayor_prioridad = 1000000;

            while (aux != null) {
                if (aux.getDato() instanceof Tarea) {
                    Tarea actual = (Tarea) aux.getDato();
                    if (actual.getPrioridad() < mayor_prioridad) {
                        mayor_prioridad = actual.getPrioridad();
                        tempo = aux;
                    }
                }
                aux = aux.siguiente;
            }
            if(tempo==null){
                System.out.println("No hay tareas con prioridad");
                return null;
            }

            return tempo.getDato();
        }
    }
    //Invertir lista enlazada
    public void invertirTareas() {
        Node<T> anterior = null;
        Node<T> actual = cabecera;
        Node<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.siguiente;   // guardar el siguiente nodo
            actual.siguiente = anterior;    // invertir el enlace
            anterior = actual;              // avanzar anterior
            actual = siguiente;             // avanzar actual
        }

        cabecera = anterior; // actualizar la cabecera al nuevo inicio
    }

    public void invertirTarea() {
        Node<T> anterior = null;
        Node<T> actual = cabecera;
        Node<T> siguiente = null;

        while (actual != null) {
            siguiente=actual.siguiente;
            actual.siguiente=anterior;

        }

        cabecera = anterior; // actualizar la cabecera al nuevo inicio
    }

    public void agregarTareCompletada(T tarea){
        if(buscaTarea(tarea)){
            tareas.add(tarea);
            System.out.println("Tarea completada");
            eliminarTarea(tarea);
            return;
        }

    }
    public void imprimirTareasCompletadas(){
        System.out.println("Tareas completadas: ");
        for(T tarea:tareas){
            System.out.println("Tarea: "+tarea);
        }
    }
    //Muestra todas las tareas
    public void imprimirTareas(){
        //Verificamos que no este vacia
        if(estaVacia()){
            return;
        }
        else{
            Node<T> aux= cabecera;
            System.out.println("Tareas existentes: ");
            while(aux!=null){
                System.out.println("Tarea: "+aux.getDato());
                aux=aux.siguiente;
            }

        }
    }

    //Verifica si la lista esta vacia
    public boolean estaVacia(){
        if(cabecera==null){
            System.out.println("Lista vacia");
            return true;
        }
        return false;
    }

}

package Guia5.Actividad;

public class Main {
    public static void main(String []args){
        GestorTareas<Tarea> gestor = new GestorTareas<>();
        Tarea tarea1=new Tarea("Estudiar", 1);
        Tarea tarea2=new Tarea("Trabajar", 2);
        Tarea tarea3=new Tarea("Jugar", 3);
        //Agregar tareas
        gestor.agregarTarea(tarea1);
        gestor.agregarTarea(tarea2);
        gestor.agregarTarea(tarea3);
        gestor.imprimirTareas();
        //Eliminar tarea
        //gestor.eliminarTarea(tarea3);
        gestor.imprimirTareas();
        //Busca tarea
        gestor.buscaTarea(tarea1);
        //Invertir tareas
        gestor.invertirTareas();
        gestor.imprimirTareas();
        //Transferir tarea completada
        gestor.agregarTareCompletada(tarea1);
        //Imprimir ambas listas
        gestor.imprimirTareas();
        gestor.imprimirTareasCompletadas();

    }

}

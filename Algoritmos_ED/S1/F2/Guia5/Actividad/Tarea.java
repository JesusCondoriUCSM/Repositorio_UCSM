package Guia5.Actividad;

public class Tarea {
    private String titulo;
    private int prioridad;

    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String toString() {
        return  titulo + ", Prioridad: " + prioridad +"\n";
    }
}

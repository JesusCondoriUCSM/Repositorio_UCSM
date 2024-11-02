package conexion;

public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String genero;
    private int duracion;

    public Pelicula(int idPelicula, String titulo, String genero, int duracion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }
}

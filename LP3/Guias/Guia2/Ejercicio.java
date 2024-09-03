package lp3_e;
import java.util.ArrayList;
import java.util.List;

abstract class Persona {
    protected String nombre;
    protected String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public abstract String getTipo(); // Método abstracto
}

class Estudiante extends Persona {
    private int codigo;
    private String carrera;

    public Estudiante(String nombre, String apellido, int codigo, String carrera) {
        super(nombre, apellido);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getCarrera() {
        return this.carrera;
    }

    @Override
    public String getTipo() {
        return "Estudiante";
    }
}

class Profesor extends Persona {
    private String departamento;

    public Profesor(String nombre, String apellido, String departamento) {
        super(nombre, apellido);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    @Override
    public String getTipo() {
        return "Profesor";
    }
}

class Curso {
    private String categoria;
    private int contadorInscritos;
    private List<Estudiante> estudiantes;

    public Curso(String categoria) {
        this.categoria = categoria;
        this.contadorInscritos = 0;
        this.estudiantes = new ArrayList<>();
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        contadorInscritos++;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getContadorInscritos() {
        return this.contadorInscritos;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
class SistemaGestion {
    private List<Curso> cursos;
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;

    public SistemaGestion() {
        cursos = new ArrayList<>();
        estudiantes = new ArrayList<>();
        profesores = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void inscribirEstudianteEnCurso(Estudiante estudiante, Curso curso) {
        curso.inscribirEstudiante(estudiante);
        System.out.println("El estudiante " + estudiante.getNombreCompleto() + " se ha inscrito en el curso de " + curso.getCategoria());
    }

    public void mostrarEstadisticasCursos() {
        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getCategoria() + " - Inscritos: " + curso.getContadorInscritos());
        }
    }

    public void mostrarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Estudiante: " + estudiante.getNombreCompleto() + " - Código: " + estudiante.getCodigo());
        }
    }
}

public class Gestion_U {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();

     
        Estudiante estudiante1 = new Estudiante("Juan", "Perez", 12345, "Ingeniería");
        Estudiante estudiante2 = new Estudiante("Carlos", "Gomez", 67890, "Matemáticas");

       
        Profesor profesor1 = new Profesor("Gomez", "Martinez", "Ciencias de la Computación");


        Curso curso1 = new Curso("Programación en Java");
        Curso curso2 = new Curso("Matemática");

        // Agregar estudiantes, profesores y cursos al sistema
        sistema.agregarEstudiante(estudiante1);
        sistema.agregarEstudiante(estudiante2);
        sistema.agregarProfesor(profesor1);
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);

        // Inscribir estudiantes en cursos
        sistema.inscribirEstudianteEnCurso(estudiante1, curso1);
        sistema.inscribirEstudianteEnCurso(estudiante2, curso2);

        // Mostrar estadísticas de cursos
        sistema.mostrarEstadisticasCursos();
        
        sistema.mostrarEstudiantes();
    }
}

//Ejercicio 4
package lp1_4_3;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

class RegistroEstudiantes{
	private List<Estudiante> lista_estudiantes;
	public RegistroEstudiantes() {
		this.lista_estudiantes=new ArrayList<>();
	}
	public void agregarEstudiante(Estudiante e) {
		try{
			if(e==null || e.getNombre()==null || e.getNombre().isEmpty()) { //String vacio o nulo 
				throw new IllegalArgumentException("Nombre nulo");
			}
			lista_estudiantes.add(e);
			System.out.println("Se agregó correctamente al estudiante");
		}
		catch(IllegalArgumentException i) {
			System.out.println("Error: "+i.getMessage());
		}
	}
	public void buscarEstudiante(Estudiante e) {
		try {
			if(!lista_estudiantes.contains(e)) {
				throw new NoSuchElementException("No se encontró al estudiante");
			}
			System.out.println("Se encontró al estudiante en el arreglo");
		}
		catch(NoSuchElementException n) {
			System.out.println("Error: "+n.getMessage());
		}
	}
}

class Estudiante{
	private String nombre;
	public Estudiante(String n) {this.nombre=n;}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String n) {
		this.nombre=n;
	}
}

public class MainRegistro {
	public static void main(String [] args) {
		Estudiante estu1=new Estudiante("");
		Estudiante estu2=new Estudiante("Lucas");
		Estudiante estu3=new Estudiante("Jesus");
		RegistroEstudiantes registro=new RegistroEstudiantes();
		registro.agregarEstudiante(estu1);
		registro.buscarEstudiante(estu2);
		registro.agregarEstudiante(estu3);
		
	}

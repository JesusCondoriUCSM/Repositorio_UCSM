package Ejer1;

import java.util.ArrayList;
import java.util.List;

// Interfaz Observer (Observador)
interface Observer {
    void actualizar(String mensaje);
}

// Clase Usuario
class Usuario {
    private String nombre;
    private boolean suscripcion;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }
    public boolean getSuscripcion() {
        return this.suscripcion;
    }
    public void suscribirse() {
    	this.suscripcion=true;
    }
    public void deSuscribirse() {
    	this.suscripcion=false;
    }
    
    public void recibirNotificacion(String mensaje) {
        System.out.println(nombre + " recibió la notificación: " + mensaje);
    }
}

//Clase Notificacion (Observador)
class Notificacion implements Observer {
 private Usuario usuario;

 public Notificacion(Usuario usuario) {
     this.usuario = usuario;
 }

 
 @Override
 public void actualizar(String mensaje) {
     if (usuario.getSuscripcion()) {
         usuario.recibirNotificacion(mensaje);
     }
     
 }
}
// Clase Eventos
class Eventos {
    private List<Observer> observers = new ArrayList<>();
    private List<String> promociones = new ArrayList<>();
    private List<String> productos = new ArrayList<>();

    // Métodos para gestionar observadores
    public void agregarObservador(Observer observer) {
        observers.add(observer);
    }

    public void eliminarObservador(Observer observer) {
        observers.remove(observer);
    }

    // Métodos para agregar contenido y notificar a los observadores
    public void agregarPromocion(String promo) {
        promociones.add(promo);
        notificarObservadores("Nueva promoción: " + promo);
    }

    public void agregarProducto(String producto) {
        productos.add(producto);
        notificarObservadores("Nueva actualización de producto: " + producto);
    }

    private void notificarObservadores(String mensaje) {
        for (Observer observer : observers) {
            observer.actualizar(mensaje);
        }
    }

    // Métodos para visualizar contenido
    public void verPromociones() {
        System.out.println("Promociones disponibles:");
        for (String promo : promociones) {
            System.out.println("- " + promo);
        }
    }

    public void verProductos() {
        System.out.println("Productos actualizados:");
        for (String producto : productos) {
            System.out.println("- " + producto);
        }
    }
}

// Clase principal para probar el sistema
public class Main_Noti {
    public static void main(String[] args) {
        Eventos eventos = new Eventos();

        // Crear usuarios
        Usuario usuario1 = new Usuario("Jesus");
        Usuario usuario2 = new Usuario("Carlos");
        Usuario usuario3 = new Usuario("Marta");
        usuario1.suscribirse();
        usuario2.suscribirse();
        usuario3.suscribirse();

        // Asociar notificaciones con los usuarios
        Notificacion noti1 = new Notificacion(usuario1);
        Notificacion noti2 = new Notificacion(usuario2);
        Notificacion noti3 = new Notificacion(usuario3);

        // Registrar observadores
        eventos.agregarObservador(noti1);
        eventos.agregarObservador(noti2);
        eventos.agregarObservador(noti3);

        // Enviar notificaciones
        eventos.agregarPromocion("¡Descuento del 50%!");
        eventos.agregarProducto("Nuevo producto agregado.");

        // Eliminar un observador
        eventos.eliminarObservador(noti1);
        
        //Desuscribirse
        usuario1.deSuscribirse();
        
        // Enviar otra notificación
        eventos.agregarPromocion("Oferta especial por tiempo limitado.");
    }
}

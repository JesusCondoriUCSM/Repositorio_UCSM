package conexion;

public class Boleta {
   private int idBoleta;
   private int idUsuario;
   private int idFuncion;
   private double precio;

   public Boleta(int idBoleta, int idUsuario, int idFuncion, double precio) {
       this.idBoleta = idBoleta;
       this.idUsuario = idUsuario;
       this.idFuncion = idFuncion;
       this.precio = precio;
   }

   public int getIdBoleta() {
       return idBoleta;
   }

   public int getIdUsuario() {
       return idUsuario;
   }

   public int getIdFuncion() {
       return idFuncion;
   }

   public double getPrecio() {
       return precio;
   }
}

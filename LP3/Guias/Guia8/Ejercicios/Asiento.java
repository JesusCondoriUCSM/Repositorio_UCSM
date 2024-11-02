package conexion;

public class Asiento {
   private int idAsiento;
   private String numeroAsiento;
   private String estado;

   public Asiento(int idAsiento, String numeroAsiento, String estado) {
       this.idAsiento = idAsiento;
       this.numeroAsiento = numeroAsiento;
       this.estado = estado;
   }

   public int getIdAsiento() {
       return idAsiento;
   }

   public String getNumeroAsiento() {
       return numeroAsiento;
   }

   public String getEstado() {
       return estado;
   }
}

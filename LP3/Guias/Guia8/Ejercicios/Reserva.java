package conexion;

public class Reserva {
   private int idReserva;
   private int idBoleta; 
   private int idAsiento; 

   public Reserva(int idReserva, int idBoleta, int idAsiento) { 
       this.idReserva = idReserva; 
       this.idBoleta = idBoleta; 
       this.idAsiento = idAsiento; 
   } 

   public int getIdReserva() { 
       return idReserva; 
   } 

   public int getIdBoleta() { 
       return idBoleta; 
   } 

   public int getIdAsiento() { 
       return idAsiento; 
   } 

}

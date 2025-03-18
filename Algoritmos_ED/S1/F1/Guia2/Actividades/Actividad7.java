package AED_1F2;

public class Main {
	
	
	public static void main(String[] args) {
		Bolsa < Chocolatina > bolsaCho = new Bolsa < Chocolatina > (3); 
		
		Chocolatina c = new Chocolatina("milka");
		Chocolatina c1 = new Chocolatina("milka"); 
		Chocolatina c2 = new Chocolatina("ferrero"); 
		bolsaCho.add(c);
		bolsaCho.add(c1); 
		bolsaCho.add(c2);
		for (Chocolatina chocolatina: bolsaCho) { 
			System.out.println(chocolatina.getMarca());
		}
		//Bolsa golosinas
		Bolsa <Golosina> bolsaGol = new Bolsa<Golosina>(3);
		Golosina gol1= new Golosina("Chupetin",2.50);
		Golosina gol2= new Golosina("Caramelo",1.20);
		Golosina gol3= new Golosina("Chocolate",4.30);
		bolsaGol.add(gol1);
		bolsaGol.add(gol2);
		bolsaGol.add(gol3);
		
		for (Golosina golosina: bolsaGol) { 
			System.out.println("Nombre: "+golosina.getNombre());
			System.out.println("Peso: "+golosina.getPeso());
		}
	}
}

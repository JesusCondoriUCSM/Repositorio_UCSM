package Ejer2;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
interface StrategiaDescuento{
	double aplicarDescuento(double precio);
}
class SinDescuento implements StrategiaDescuento{
	public double aplicarDescuento(double precio) {
		return precio;
	}
}
class DescuentoFijo implements StrategiaDescuento{
	public double aplicarDescuento(double precio) {
		return precio*0.9;
	}
}
class DescuentoPorcentual implements StrategiaDescuento{
	private CarritoCompras carrito;
	public DescuentoPorcentual(CarritoCompras c) {
		this.carrito=c;
	}
	
	public double aplicarDescuento(double precio) {
		if(carrito.getProductos().get(0).getNombre().equals(carrito.getProductos().get(1).getNombre())) {
			return precio*0.7; //Dos productos iguales 30% de descuento
		}else {
			System.out.println("No se aplica el descuento porcentual");
			return precio*0.9;
		}
	}
}
class DescuentoPorcentualAcumulado implements StrategiaDescuento{
	private CarritoCompras carrito;
	public DescuentoPorcentualAcumulado(CarritoCompras c) {
		this.carrito=c;
	}
	
	public double aplicarDescuento(double precio) {
		if(carrito.getProductos().size()==2) {
			if(carrito.getProductos().get(0).getNombre().equals(carrito.getProductos().get(1).getNombre())) {
				return precio*0.7; //Dos productos iguales 30% de descuento
			}
		}else if(carrito.getProductos().size()>=3) {
			double menor=1000000000;
			for(Producto prod:carrito.getProductos()) {
				if(prod.getPrecio()<menor) {
					menor=prod.getPrecio();
				}
			}
			double suma=0;
			for(Producto prod:carrito.getProductos()) {
				if(prod.precio!=menor) {
					suma+=prod.getPrecio();
				}
			}
			return suma+(menor/2);
			
			
			
		}
		return 0;
		
	}
}
class CarritoCompras{
	private List<Producto> productos=new ArrayList<>();
	
	public List<Producto> getProductos(){
		return productos;
	}
	public int sumaPreciosProductos() {
		int suma=0;
		for(Producto prod:productos) {
			suma+=prod.getPrecio();
		}
		return suma;
		
	}
	public void agregarProductos(Producto prod) {
		productos.add(prod);
	}
	public void eliminarProductos(Producto prod) {
		productos.remove(prod);
	}
	
}
class Producto{
	String nombre;
	double precio;
	public Producto(String n,double p) {
		this.nombre=n;
		this.precio=p;
	}
	public String getNombre() {
		return this.nombre;
	}
	public double getPrecio() {
		return this.precio;
	}
}
class CalculadoraDePrecios{
	private StrategiaDescuento estrategia;
	private CarritoCompras carrito;
	
	public CalculadoraDePrecios(CarritoCompras c) {
		this.carrito=c;
	}
	public void setEstrategia(StrategiaDescuento estrategia) {
		this.estrategia=estrategia;
	}
	
	public double calcularPrecio(double precio) {
		
		return estrategia.aplicarDescuento(precio);
	}
}
public class Main_P {
	public static void main(String [] args) {
		Scanner scanner=new Scanner(System.in);
		int opc=-1;
		Producto prod1=new Producto("TV",1000);
		Producto prod2=new Producto("Aspiradora",400);
		Producto prod3=new Producto("Carro",60000);
		Producto prod4=new Producto("TV",1000);
		
		CarritoCompras car1=new CarritoCompras();
		CarritoCompras car2=new CarritoCompras();
		CarritoCompras car3=new CarritoCompras();
		car1.agregarProductos(prod1); //Agrega productos al carrito de compras
		
		car2.agregarProductos(prod1);
		car2.agregarProductos(prod4);
		
		car3.agregarProductos(prod1);
		car3.agregarProductos(prod2);
		car3.agregarProductos(prod3);
		
		CalculadoraDePrecios calculo1=new CalculadoraDePrecios(car1);
		CalculadoraDePrecios calculo2=new CalculadoraDePrecios(car2);
		CalculadoraDePrecios calculo3=new CalculadoraDePrecios(car3);
		while(opc!=5) {
			System.out.println("1.Sin descuento\n2.Descuento fijo\n3.Descuento porcentual (2 productos iguales)\n4.Descuento porcentual acumulado (a partir de 3 productos)\n5.Salir");
			opc=scanner.nextInt();
			switch(opc) {
			case 1:
				calculo1.setEstrategia(new SinDescuento());
				System.out.println("Precio total sin descuento: "+calculo1.calcularPrecio(car1.sumaPreciosProductos()));
				break;
			case 2:
				calculo1.setEstrategia(new DescuentoFijo());
				System.out.println("Precio total con descuento fijo: "+calculo1.calcularPrecio(car1.sumaPreciosProductos()));
				break;
			case 3:
				calculo2.setEstrategia(new DescuentoPorcentual(car2));
				System.out.println("Precio total con descuento porcentual: "+calculo2.calcularPrecio(car2.sumaPreciosProductos()));
				break;
			case 4:
				calculo3.setEstrategia(new DescuentoPorcentualAcumulado(car3));
				System.out.println("Precio total con descuento porcentual acumulado: "+calculo3.calcularPrecio(car3.sumaPreciosProductos()));
				break;
				
			case 5:
				System.out.println("Saliendo del programa...");
				break;
			
			default:
				System.out.println("Opcion invalida");
			}
		}
	}
}


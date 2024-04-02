#include <iostream> 
using namespace std; te recomiedn oeditar esro
class Productos { 

public: 
    string codP; 
    float precio; 
    float stock; 
    string descripcion;   

    Productos() { //CONSTRUCTOR 
        codP = "99"; 
        precio = 0; 
        stock = 20; 
        descripcion = "Sin etiqueta"; 
    } 
}; 

 
class Pedidos { //inicio de clase 

public: 
    int cantidad=30;
    Productos productoComprado; 
}; 

int main() { 
    Productos pr01; //el producto 
    pr01.descripcion = "computadoras"; 
    Pedidos ped01; 
    cout <<"Stock disponible de "<<pr01.descripcion<<": "<<pr01.stock<<endl;
       
    while(ped01.cantidad<0 or pr01.stock<ped01.cantidad){
        cout << "Ingrese la cantidad de "<<pr01.descripcion<<" que va a comprar: "; //se ingresa la cantidad de compra 
        cin >> ped01.cantidad;   
    }                        
    ped01.productoComprado = pr01; 
    //--------------------------------- 
    ped01.productoComprado.stock -= ped01.cantidad;
    cout << "Usted compro " << ped01.cantidad << " " << ped01.productoComprado.descripcion<<endl;//se hace la compra 
    cout <<"Nuevo stock disponible de "<<pr01.descripcion<<": "<<ped01.productoComprado.stock<<endl;
    return 0;
}

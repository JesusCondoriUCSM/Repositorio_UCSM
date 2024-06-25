#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Productos{
    private:
        string nombre;  //Atributos
        int codigo;
        string descripcion;
        int cantidad_disponible;
    public:
        Productos(string n,int c,string d,int cant):nombre(n),codigo(c),descripcion(d),cantidad_disponible(cant){}
        string getNombre(){return nombre;}
        int getCodigo(){return codigo;}     //Getters
        string getDescripcion(){return descripcion;}
        int getCantidad(){return cantidad_disponible;}

        void setNombre(string n){nombre=n;}
        void setCodigo(int c){codigo=c;}    //Setters
        void setDescripcion(string d){descripcion=d;}
        void setCantidad(int c){cantidad_disponible=c;}
};
struct CompararDescripcion {    //Compara descripciones
    bool operator()(Productos* p1, Productos* p2){  //Sobrecarga () para usar la estructura como funcion
        return p1->getDescripcion() < p2->getDescripcion();
    }
};
class Inventario{
    private:
        vector <Productos*> productos;  //vector de referencia a objetos de la clase Productos
    public:
        void Agregar_producto(){    //Metodo para agregar productos
            int cantidad;
            int codigo;
            string descripcion,nombre;
            cout<<"Producto:"<<endl;
            cin>>nombre;
            cout<<"Codigo:"<<endl;
            cin>>codigo;
            for(auto it=productos.begin();it!=productos.end();++it){    //Cerifica que sea codigo unico
                while((*it)->getCodigo()==codigo){
                    cout<<"El codigo ya esta registrado"<<endl;
                    cout<<"Codigo:"<<endl;
                    cin>>codigo;
                }
            }
            cin.ignore();   //Limpia el buffer de entrada
            cout<<"Descripcion:"<<endl;
            getline(cin,descripcion);   //Lee toda la linea ingresada

            while (true){
                try
                {
                cout<<"Cantidad:"<<endl;
                cin>>cantidad;
                if (cantidad<0){
                    throw runtime_error("cantidad menor a 0");
                }
                break;
                }
                catch(runtime_error &e)
                {
                    cout<<"Error "<<e.what()<<endl;
                    cin.clear();
                }
                catch(...){
                    cout<<"Ocurrio un error inesperado"<<endl;
                    cin.clear();
                }
            }
            Productos *prod=new Productos(nombre,codigo,descripcion,cantidad);  //Crea referencia a un objeto dinamico que se agrega al vector
            productos.push_back(prod);
            
        }
        void Actualizar_cantidad(){
            string nombre;
            int cantidad;
            bool producto_encontrado=false;
            cout<<"Ingrese el nombre del producto"<<endl;
            cin>>nombre;
            for(auto it=productos.begin();it!=productos.end();++it){    //Recorre el vector con un iterador
                if((*it)->getNombre()==nombre){
                    cout<<"Nueva cantidad:"<<endl;
                    cin>>cantidad;
                    (*it)->setCantidad(cantidad);
                    producto_encontrado=true;
                }
            }
            if(!producto_encontrado){       //Verifica si el producto se encuentra en el vector
                cout<<"Producto no encontrado"<<endl;
            }

        }
        void BuscarProducto_Codigo(){
            int codigo;
            bool producto_encontrado=false;
            cout<<"Ingrese el codigo del producto"<<endl;
            cin>>codigo;
            for(auto it=productos.begin();it!=productos.end();++it){
                if((*it)->getCodigo()==codigo){
                    cout<<"Producto:"<<(*it)->getNombre()<<endl;
                    cout<<"Codigo:"<<(*it)->getCodigo()<<endl;
                    cout<<"Descripcion:"<<(*it)->getDescripcion()<<endl;
                    cout<<"Cantidad:"<<(*it)->getCantidad()<<endl;
                    producto_encontrado=true;
                }
            }
            if(!producto_encontrado){
                cout<<"Producto no encontrado"<<endl;
            }
        }
        void MostrarProductos_Alfa(){
            sort(productos.begin(), productos.end(), CompararDescripcion());    //Llama a la estructura, pero como se sobrecargo el operador ()                                                                   se
            for(auto it=productos.begin();it!=productos.end();++it){            //se puede usar como funcion
                cout<<"Producto:"<<(*it)->getNombre()<<endl;    
                cout<<"Codigo:"<<(*it)->getCodigo()<<endl;
                cout<<"Descripcion:"<<(*it)->getDescripcion()<<endl;
                cout<<"Cantidad:"<<(*it)->getCantidad()<<endl;
                cout<<"---------------"<<endl;
            }
        }
    
};

int main(){
    int opc=0;
    Inventario inventario;
    while (opc!=5){
        cout<<"--------------------"<<endl;
        cout<<"Seleccione una opcion:"<<endl;
        cout<<"1.Agregar productos\n2.Actualizar cantidad\n3.Buscar producto\n4.Mostrar productos ordenados\n5.Salir"<<endl;
        cout<<"--------------------"<<endl;
        cin>>opc;
        switch (opc)
        {
        case 1:
            inventario.Agregar_producto();
            break;
        case 2:
            inventario.Actualizar_cantidad();
            break;
        case 3:
            inventario.BuscarProducto_Codigo();
            break;
        case 4:
            inventario.MostrarProductos_Alfa();
            break;
        case 5:
            break;
        default:
            cout<<"Opcion invalida"<<endl;
            break;
        }
    }
    
    return 0;
}

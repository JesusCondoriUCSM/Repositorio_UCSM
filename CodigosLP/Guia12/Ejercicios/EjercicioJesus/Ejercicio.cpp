#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Productos{
    private:
        string nombre;
        int codigo;
        string descripcion;
        int cantidad_disponible;
    public:
        Productos(string n,int c,string d,int cant):nombre(n),codigo(c),descripcion(d),cantidad_disponible(cant){}
        string getNombre(){return nombre;}
        int getCodigo(){return codigo;}
        string getDescripcion(){return descripcion;}
        int getCantidad(){return cantidad_disponible;}

        void setNombre(string n){nombre=n;}
        void setCodigo(int c){codigo=c;}
        void setDescripcion(string d){descripcion=d;}
        void setCantidad(int c){cantidad_disponible=c;}
};
struct CompararDescripcion {
    bool operator()(Productos* p1, Productos* p2){
        return p1->getDescripcion() < p2->getDescripcion();
    }
};
class Inventario{
    private:
        vector <Productos*> productos;
    public:
        void Agregar_producto(){
            int cantidad;
            int codigo;
            string descripcion,nombre;
            cout<<"Producto:"<<endl;
            cin>>nombre;
            cout<<"Codigo:"<<endl;
            cin>>codigo;
            for(auto it=productos.begin();it!=productos.end();++it){
                while((*it)->getCodigo()==codigo){
                    cout<<"El codigo ya esta registrado"<<endl;
                    cout<<"Codigo:"<<endl;
                    cin>>codigo;
                }
            }
            cin.ignore();
            cout<<"Descripcion:"<<endl;
            getline(cin,descripcion);

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
            Productos *prod=new Productos(nombre,codigo,descripcion,cantidad);
            productos.push_back(prod);
            
        }
        void Actualizar_cantidad(){
            string nombre;
            int cantidad;
            bool producto_encontrado=false;
            cout<<"Ingrese el nombre del producto"<<endl;
            cin>>nombre;
            for(auto it=productos.begin();it!=productos.end();++it){
                if((*it)->getNombre()==nombre){
                    cout<<"Nueva cantidad:"<<endl;
                    cin>>cantidad;
                    (*it)->setCantidad(cantidad);
                    producto_encontrado=true;
                }
            }
            if(!producto_encontrado){
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
            sort(productos.begin(), productos.end(), CompararDescripcion());
            for(auto it=productos.begin();it!=productos.end();++it){
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

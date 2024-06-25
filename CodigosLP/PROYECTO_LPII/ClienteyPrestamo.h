#ifndef CLIENTEYPRESTAMO_H
#define CLIENTEYPRESTAMO_H

#include <iostream>
#include <vector>
using namespace std;

class Prestamo;

class Cliente{
    protected:
        string nombre;
        string apellido;
        int telefono;
        int dni;
        vector<class Prestamo*> prestamos;
    public:
        //Constructor
        Cliente(string n, string a, int t, int d):
        nombre(n), apellido(a), telefono(t), dni(d){}
        //sets
        void setNombre(string n){this->nombre = n;}
        void setApellido(string a){this->apellido = a;}
        void setTelefono(int t){this->telefono = t;}
        void setDni(int d){this->dni = d;}
        //gets
        string getNombre(){return this->nombre;}
        string getApellido(){return this->apellido;}
        int getTelefono(){return this->telefono;}
        int getDni(){return this->dni;}
        //Sobrecarga
        friend ostream& operator<<(ostream& os,Cliente& cli){
            os << "Nombre: " << cli.nombre << endl;
            os << "Apellido: " << cli.apellido << endl;
            os << "Telefono: " << cli.telefono << endl;
            os << "DNI: " << cli.dni << endl;
            return os;
        }
        //Agregar prestamos
        void agregarPrestamo(Prestamo* p){
            this->prestamos.push_back(p);
        }
        //Eliminar prestamo
        void eliminarPrestamo(int id);
};

class Prestamo{
    protected:
        Cliente& cliente;
        string fecha_prest;
        string fecha_dev;
        double multa;
        int id;
    public:
    //Constructor
    Prestamo(Cliente& c, string fp, string fd, int id):
    cliente(c), fecha_prest(fp), fecha_dev(fd), multa(0),id(id){}

    //sets
    void setFecha_prest(string fp){this->fecha_prest = fp;}
    void setFecha_dev(string fd){this->fecha_dev = fd;}
    void setMulta(double m){this->multa = m;}

    //gets
    Cliente& getCliente(){return this->cliente;}
    string getFecha_prest(){return this->fecha_prest;}
    string getFecha_dev(){return this->fecha_dev;}
    double getMulta(){return this->multa;}
    int getId(){return this->id;}
    
    //Metodo
    void mostrarPrestamo(){
        cout << "Cliente: " << this->cliente << endl;
        cout << "Fecha de prestamo: "<< this->fecha_prest <<endl;
        cout << "Fecha de decolucion: "<< this->fecha_dev <<endl;
        cout << "Multa: "<< this->multa <<endl;
    }

};

void Cliente::eliminarPrestamo(int id) {
    for (int i = 0; i < this->prestamos.size(); i++) {
        if (prestamos[i]->getId() == id) {
            prestamos.erase(prestamos.begin() + i);
            break;
        }
    }
}

#endif
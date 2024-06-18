#ifndef CLIENTE_H
#define CLIENTE_H

#include <iostream>
using namespace std;

class Cliente{
    protected:
        //Atributos
        string nombre;
        string apellido;
        int telefono;
        string DNI;
    public:
        //Constructor
        Cliente(string n, string a, int t, string DNI)
        :nombre(n), apellido(a), telefono(t), DNI(DNI){}
        //gets
        string getNombre(){return this->nombre;}
        string getApellido(){return this->apellido;}
        int getTelefono(){return this->telefono;}
        string getDNI(){return this->DNI;}
        //Sobrecarga
        friend ostream& operator<<(ostream& os,Cliente& cli){
            os << "Nombre: " << cli.nombre << endl;
            os << "Apellido: " << cli.apellido << endl;
            os << "Telefono: " << cli.telefono << endl;
            os << "DNI: " << cli.DNI << endl;
            return os;
        }
};

#endif
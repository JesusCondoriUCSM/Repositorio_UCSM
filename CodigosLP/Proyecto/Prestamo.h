#ifndef PRESTAMO_H
#define PRESTAMO_H

#include <iostream>
#include "Cliente.h"

class Prestamo{
    protected:
        //Atributos
        Cliente cliente;
        string fecha;
    public:
        //Constructor
        Prestamo(Cliente cli, string f):cliente(cli),fecha(f){}
        //Metodos
        //Mostrar detalles:
        void mostrarDetalles(){
            cout<<"Cliente: \n"<<this->cliente<<endl;
            cout<<"Fecha: "<<this->fecha<<endl;
        }
};
#endif
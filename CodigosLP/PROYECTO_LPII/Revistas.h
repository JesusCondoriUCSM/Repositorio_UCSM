#ifndef REVISTAS_H
#define REVISTAS_H

#include <iostream>
#include "Material.h"
using namespace std;

class Revistas : public Material{
    private:
        string Editorial;
        int num_edicion;
        string a_pub;
    public:
        //Constructor
        Revistas(string t, string a, int c, string e, int ne, string ap):
        Material(t, a, c), Editorial(e), num_edicion(ne), a_pub(ap){}

        //sets
        void setEditorial(string e){this->Editorial = e;}
        void setNum_edicion(int ne){this->num_edicion = ne;}
        void setA_pub(string ap){this->a_pub = ap;}

        //gets
        string getEditorial(){return this->Editorial;}
        int getNum_edicion(){return this->num_edicion;}
        string getA_pub(){return this->a_pub;}

        //Sobreescritura del metodo mostrarDetalles
        void mostrarDetalles(){
            Material::mostrarDetalles(); //Llama al metodo de la clase base
            cout << "Editorial: " << Editorial << endl;
            cout << "Numero de edicion: " << num_edicion << endl;
            cout << "Anio de publicacion: " << a_pub << endl;
        }
};

#endif
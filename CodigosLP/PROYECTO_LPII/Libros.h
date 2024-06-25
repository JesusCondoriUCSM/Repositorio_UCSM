#ifndef LIBROS_H
#define LIBROS_H

#include <iostream>
#include "Material.h"
using namespace std;

class Libros : public Material{
    private:
        string Editorial;
        int a_pub;
        string idioma;
    public:
        Libros(string t, string a, int c, string e, int ap, string i):
        Material(t, a, c), Editorial(e), a_pub(ap), idioma(i){}

        //sets
        void setEditorial(string e){this->Editorial = e;}
        void setA_pub(int ap){this->a_pub = ap;}
        void setIdioma(string i){this->idioma = i;}

        //gets
        string getEditorial(){return this->Editorial;}
        int getA_pub(){return this->a_pub;}
        string getIdioma(){return this->idioma;}

        //Sobrescritura del metodo mostrarDetalles
        void mostrarDetalles(){
            Material::mostrarDetalles(); //Llama al metodo de la clase base
            cout << "Editorial: " << Editorial << endl;
            cout << "Anio de publicación: " << a_pub << endl;
            cout << "Idioma: " << idioma << endl;
        }
};

#endif
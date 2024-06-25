#ifndef MATERIAL_H
#define MATERIAL_H

#include <iostream>
using namespace std;

class Material{
    protected:
        string titulo;
        string autor;
        int codigo;
        //Constructor
        Material(string t, string a, int c):
        titulo(t), autor(a), codigo(c){}
    public:
        //Destructor
        virtual ~Material(){}

        //Metodo virtual
        virtual void mostrarDetalles(){
            cout << "Titulo: " << titulo << endl;
            cout << "Autor: " << autor << endl;
            cout << "Codigo: " << codigo << endl;
        }
        //sets
        void setTitulo(string t){this->titulo = t;}
        void setAutor(string a){this->autor = a;}
        void setCodigo(int c){this->codigo = c;}
        //gets
        string getTitulo(){return this->titulo;}
        string getAutor(){return this->autor;}
        int getCodigo(){return this->codigo;}
};

#endif
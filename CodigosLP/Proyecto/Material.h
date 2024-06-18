#ifndef MATERIAL_H
#define MATERIAL_H

#include <iostream>
using namespace std;

// Clase base para los materiales
class Material {
protected:
    // Atributos
    string titulo;
    string autor;
    int codigo;
    bool estado; // true=Disponible, false=No disponible

public:
    // Constructor
    Material(string t, string a, int c) : titulo(t), autor(a), codigo(c), estado(true) {}
    Material(string t, string a, int c, bool est) : titulo(t), autor(a), codigo(c), estado(est) {}

    // Método virtual que muestra los detalles del material
    virtual void mostrarDetalles() {
        cout << "Titulo: " << titulo << endl;
        cout << "Autor: " << autor << endl;
        cout << "Codigo: " << codigo << endl;
    }

    // Método get para obtener el código del material
    int get_codigo() { return codigo; }

    // Destructor virtual asegura que el destructor de la clase derivada se llame correctamente
    virtual ~Material() {}
};

#endif
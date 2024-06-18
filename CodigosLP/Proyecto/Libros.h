#ifndef LIBRO_H
#define LIBRO_H

#include <iostream>
#include "Material.h"
using namespace std;

// Clase derivada para los libros
class Libros : public Material {
protected:
    // Atributos adicionales para libros
    string fecha;
    int cant_libros;

public:
    // Constructor
    Libros(string t, string a, int c, string f, int cant) : 
    Material(t, a, c), fecha(f), cant_libros(cant) {}

    // Método sobrescrito que muestra los detalles del libro
    void mostrarDetalles(){
        Material::mostrarDetalles(); // Llama al método de la clase base
        cout << "Fecha: " << fecha << endl;
        cout << "Cantidad: " << cant_libros << endl;
    }
};

#endif
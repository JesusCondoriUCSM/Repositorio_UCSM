#ifndef REVISTAS_H
#define REVISTAS_H

#include <iostream>
#include "Material.h"
using namespace std;

// Clase derivada para las revistas
class Revistas : public Material {
protected:
    // Atributos adicionales para revistas
    string fecha;
    int cant_revistas;
    string editorial;

public:
    // Constructor
    Revistas(string t, string a, int c, string f, int cant, string e) : 
    Material(t, a, c), fecha(f), cant_revistas(cant), editorial(e) {}

    // Método sobrescrito que muestra los detalles de la revista
    void mostrarDetalles(){
        Material::mostrarDetalles(); // Llama al método de la clase base
        cout << "Fecha: " << fecha << endl;
        cout << "Cantidad: " << cant_revistas << endl;
        cout << "Editorial: " << editorial << endl;
    }
};
#endif
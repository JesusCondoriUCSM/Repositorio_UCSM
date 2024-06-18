#ifndef DVDS_H
#define DVDS_H

#include <iostream>
#include "Material.h"
using namespace std;

// Clase derivada para los DVDs
class DVDs : public Material {
protected:
    // Atributos adicionales para DVDs
    string fecha;
    int cant_dvd;

public:
    // Constructor
    DVDs(string t, string a, int c, string f, int cant) :
    Material(t, a, c), fecha(f), cant_dvd(cant) {}

    // Método sobrescrito que muestra los detalles del DVD
    void mostrarDetalles(){
        Material::mostrarDetalles(); // Llama al método de la clase base
        cout << "Fecha: " << fecha << endl;
        cout << "Cantidad: " << cant_dvd << endl;
    }
};

#endif
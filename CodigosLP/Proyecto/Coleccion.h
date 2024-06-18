#ifndef COLECCION_H
#define COLECCION_H

#include <iostream>
#include <vector>
#include <string>

#include "Material.h"
#include "Libros.h"
#include "Revistas.h"
#include "DVDs.h"

// Clase plantilla para manejar una colección de cualquier tipo de material
template<typename T>
class Coleccion {
protected:
    vector<T*> Coleccion_bib; // Vector para almacenar los materiales

public:
    // Método para agregar materiales a la colección
    void agregar_material(T* material_bib) {
        Coleccion_bib.push_back(material_bib);
    }

    // Método para eliminar materiales de la colección
    void borrar_material(T* material_del) {
        if (Coleccion_bib.size() != 0) {
            for (int i = 0; i < Coleccion_bib.size(); i++) {
                if (Coleccion_bib[i] == material_del) {
                    Coleccion_bib.erase(Coleccion_bib.begin() + i);
                    break;
                }
            }
        } else {
            cout << "No hay materiales en la coleccion" << endl;
        }
    }

    // Método para mostrar todos los materiales en la colección
    void mostrar_coleccion() {
        if (Coleccion_bib.size() != 0) {
            for (int i = 0; i < Coleccion_bib.size(); i++) {
                Coleccion_bib[i]->mostrarDetalles();
            }
        } else {
            cout << "No hay materiales en la coleccion" << endl;
        }
    }

    // Método para buscar material en la colección por código
    T* buscar_material(int codigo) {
        for (int i = 0; i < Coleccion_bib.size(); i++) {
            if (Coleccion_bib[i]->get_codigo() == codigo) {
                return Coleccion_bib[i];
            }
        }
        return nullptr;
    }

    // Destructor que elimina todos los materiales de la colección
    ~Coleccion(){
        for(int i = 0; i < Coleccion_bib.size(); i++){
            delete Coleccion_bib[i];
        }
    }
};

#endif
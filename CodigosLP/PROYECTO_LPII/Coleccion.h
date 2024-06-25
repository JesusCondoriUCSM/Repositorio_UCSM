#ifndef COLECCION_H
#define COLECCION_H

#include <iostream>
#include <vector>
#include <algorithm>
#include "Material.h"
#include "MaterialAudiovisual.h"

using namespace std;

//Semana 2-----------------Plantilla de clase
template<typename T>
class Coleccion {
    protected:
        vector<T*> Coleccion_bib; // Vector para almacenar los materiales

    public:
        // Método para agregar materiales a la colección
        void agregar_material(T* material_bib) {Coleccion_bib.push_back(material_bib);}

        // Método para eliminar materiales de la colección
        void borrar_material(int codigo) {
        auto it = find_if(Coleccion_bib.begin(), Coleccion_bib.end(), [codigo](T* m) {
            return m->getCodigo() == codigo;
        });

        if (it != Coleccion_bib.end()) {
            Coleccion_bib.erase(it);
            delete *it;
        } else {
            cout << "Material no encontrado." << endl;
        }
    }

        // Método para mostrar todos los materiales en la colección
        void mostrar_coleccion() {
            if (Coleccion_bib.empty() == false) {
                for (int i = 0; i < Coleccion_bib.size(); i++) {
                    Coleccion_bib[i]->mostrarDetalles();
                }
            } else {cout << "No hay materiales en la coleccion" << endl;}
        }

        // Método para buscar material en la colección por código
        T* buscar_material(int codigo) {
            auto it = find_if(Coleccion_bib.begin(), Coleccion_bib.end(), [codigo](T* material) {
                return material->getCodigo() == codigo;
            });

            if (it != Coleccion_bib.end()) {return *it;} 
            else {return nullptr;}
        }

        //Metodo para ordenar la coleccion
        void ordenar_coleccion(){
            sort(Coleccion_bib.begin(), Coleccion_bib.end(), [](T* a,T* b){
                return a->getCodigo() < b->getCodigo();
            });
        }
        // Destructor que elimina todos los materiales de la colección
        ~Coleccion(){
            for(int i = 0; i < Coleccion_bib.size(); i++){
                delete Coleccion_bib[i];
            }
        }
};

#endif
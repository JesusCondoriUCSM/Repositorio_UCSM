#ifndef CDS_H
#define CDS_H

#include <iostream>
#include "Material.h"
#include "MaterialAudiovisual.h"
using namespace std;

class CDs : public Material, public MaterialAudiovisual{
    private:
        string resolucion;
        string form_audio;
    public:
    //Constructor
    CDs(string t, string a, int c, string i, string g, float d,
    int apu, string r, string fa): Material(t, a, c),
    MaterialAudiovisual(i, g, d, apu),
    resolucion(r), form_audio(fa){}

    //sets
    void setResolucion(string r){this->resolucion = r;}
    void setForm_audio(string fa){this->form_audio = fa;}

    //gets
    string getResolucion(){return this->resolucion;}
    string getForm_audio(){return this->form_audio;}
    
    //Sobreescritura del metodo mostrarDetalles
    void mostrarDetalles(){
        Material::mostrarDetalles(); //Llama al metodo de la clase base
        cout << "Idioma: " << this->idioma << endl;
        cout << "Genero: " << this->genero << endl;
        cout << "Duracion: " << this->duracion << endl;
        cout << "Anio de publicacion: " << this->a_pub << endl;
        cout << "Resolucion: " << this->resolucion << endl;
        cout << "Formato de audio: " << this->form_audio << endl;
    }
};

#endif
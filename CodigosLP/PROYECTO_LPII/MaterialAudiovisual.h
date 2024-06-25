#ifndef MATERIALAUDIOVISUAL_H
#define MATERIALAUDIOVISUAL_H

#include <iostream>
using namespace std;

class MaterialAudiovisual{
    protected:
        string idioma;
        string genero;
        float duracion;
        int a_pub;
    public:
    //Constructor
    MaterialAudiovisual(string i, string g, float d, int ap):
    idioma(i), genero(g), duracion(d), a_pub(ap){}
    
    //sets
    void setIdioma(string i){this->idioma = i;}
    void setGenero(string g){this->genero = g;}
    void setDuracion(float d){this->duracion = d;}
    void setA_pub(int ap){this->a_pub = ap;}

    //gets
    string getIdioma(){return this->idioma;}
    string getGenero(){return this->genero;}
    float getDuracion(){return this->duracion;}
    int getA_pub(){return this->a_pub;}
};

#endif
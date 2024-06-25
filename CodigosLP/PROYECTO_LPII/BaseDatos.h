#ifndef BASEDATOS_H
#define BASEDATOS_H
#include <iostream>
#include <fstream>
#include <stdexcept>
using namespace std;

class BaseDatos {
    private:
        ifstream archivo;

    public:
        // Constructor
        BaseDatos() {
            try {
                archivo.open("biblioteca.txt");
                if (!archivo.is_open()) {
                    throw runtime_error("Error al abrir el archivo");
                }
                cout << "Lectura de archivo exitosa" <<endl;
            } catch (runtime_error& e) {
                cerr << "Error: " << e.what() <<endl;
            }
        }

        // Destructor
        ~BaseDatos() {
            if (archivo.is_open()) {
                archivo.close();
            }
        }
};

#endif

//EJERICIC 3
#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Animal {
public:
    virtual void comer() const = 0; //puro
    virtual void dormir() const = 0;
    virtual void moverse() const = 0;
    virtual ~Animal() {}
};

class GrupoAnimales {
public:
    virtual Animal* crearAnimal() const = 0;
    virtual ~GrupoAnimales() {}
};

// mamíferos
class Mamifero : public Animal {
public:
    void comer() const override {
        cout << "El mamífero come." << endl;
    }

    void dormir() const override {
        cout << "El mamífero duerme." << endl;
    }

    void moverse() const override {
        cout << "El mamífero se mueve." << endl;
    }
};

class GrupoMamiferos : public GrupoAnimales { //crear mamifero
public:
    Animal* crearAnimal() const override {
        return new Mamifero();
    }
};

// ave
class Ave : public Animal {
public:
    void comer() const override {
        cout << "El ave come." << endl;
    }

    void dormir() const override {
        cout << "El ave duerme." << endl;
    }

    void moverse() const override {
        cout << "El ave vuela." << endl;
    }
};


class GrupoAves : public GrupoAnimales { //crear ave
public:
    Animal* crearAnimal() const override {
        return new Ave();
    }
};

// reptiles
class Reptil : public Animal {
public:
    void comer() const override {
        cout << "El reptil come." << endl;
    }

    void dormir() const override {
        cout << "El reptil duerme." << endl;
    }

    void moverse() const override {
        cout << "El reptil se desliza." << endl;
    }
};


class GrupoReptiles : public GrupoAnimales { //crear reptiles
public:
    Animal* crearAnimal() const override {
        return new Reptil();
    }
};
 
class SimuladorAnimales { // Simulador de animales
private:
    vector<GrupoAnimales*> grupos;
public:
    void agregarGrupo(GrupoAnimales* grupo) {
        grupos.push_back(grupo); //nuevo elemento al final del vector
    }

    Animal* crearAnimal(int indice) const {
        if (indice >= 0 && indice < grupos.size()) {
            return grupos[indice]->crearAnimal();
        }
        return nullptr; //puntero
    }

    void agregarNuevaEspecie(const string& nombre, GrupoAnimales* grupo) {
        cout << "Se ha agregado la especie: " << nombre << endl;
        grupos.push_back(grupo);
    }

    void mostrarMenu() const {
        cout << "Seleccione un grupo de animales:" << endl;
        for (int i = 0; i < grupos.size(); ++i) {
            cout << i + 1 << ". ";
            if (grupos[i] == nullptr) {
                cout << "Nuevo grupo sin datos" << endl;
            } else {
                cout << "Grupo " << i + 1 << endl;
            }
        }
        cout << "0. Salir" << endl;
    }

    int cantidadGrupos() const {
        return grupos.size(); //devuelve el tamaño del vector grupos, es decir, la cantidad de elementos que contiene.
    }

    ~SimuladorAnimales() {
        for (auto& grupo : grupos) {
            delete grupo;
        }
    }
};

class GrupoNuevaEspecie : public GrupoAnimales { //nueva especie
public:
    Animal* crearAnimal() const override { //ver esta parteee
        return nullptr;
    }
};

int main() {
    SimuladorAnimales simulador;// se crea el simulador de anmels

    simulador.agregarGrupo(new GrupoMamiferos());// Se agrega grupos para especies existentes
    simulador.agregarGrupo(new GrupoAves());
    simulador.agregarGrupo(new GrupoReptiles());

    int opcion;
    string nombreGrupo;
    do {
        // Mostrar menu
        simulador.mostrarMenu();
        cout << "Opción: ";
        cin >> opcion;

        if (opcion == 0) {
            break;
        } else if (opcion > 0 && opcion <= simulador.cantidadGrupos()) {
            
            Animal* animal = simulador.crearAnimal(opcion - 1);
            if (animal) {
                cout << "Comportamiento del animal:" << endl;
                cout << "1. Comer" << endl;
                cout << "2. Dormir" << endl;
                cout << "3. Moverse" << endl;
                cout << "Seleccione una accion: ";
                int accion;
                cin >> accion;
                switch (accion) {
                    case 1:
                        animal->comer();
                        break;
                    case 2:
                        animal->dormir();
                        break;
                    case 3:
                        animal->moverse();
                        break;
                    default:
                        cout << "Opcion no valida" << endl;
                        break;
                }
                delete animal;
            } else {
                cout << "aun no hya datos"<< endl;
            }
        } else {
            cout << "Opción no válida.ingrese de nuevo" << endl;
        }

        cout << "¿Desea agregar una nueva especie? (S/N): ";
        char respuesta;
        cin >> respuesta;
        if (toupper(respuesta) == 'S') { //minuscula a masyucula
            cout << "Ingrese el nombre de la nueva especie: ";
            cin >> nombreGrupo;
            GrupoAnimales* nuevoGrupo = new GrupoNuevaEspecie();
            //  nuevo grupo al simulador
            simulador.agregarNuevaEspecie(nombreGrupo, nuevoGrupo);
        }
    } while (opcion != 0);

    return 0;
}

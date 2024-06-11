//EJERICIC 1
#include <iostream>
#include <cmath>

using namespace std;

// Clase base abstracta para formas geométricas
class FormaGeometrica {
public:
    virtual double calcularArea() const = 0;
    virtual double calcularPerimetro() const = 0;
    virtual void mostrarInformacion() const = 0;
    virtual ~FormaGeometrica() {}
};

// Circulo
class Circulo : public FormaGeometrica {
private:
    double radio;
public:
    Circulo(double r) : radio(r) {}

    double calcularArea() const override {
        return 3.1416 * radio * radio;
    }

    double calcularPerimetro() const override {
        return 2 * 3.1416 * radio;
    }

    void mostrarInformacion() const override {
        cout << "Circulo -> Radio: " << radio << ", Area: " << calcularArea() << ", Perimetro: " << calcularPerimetro() << endl;
    }
};

// Rectangulo
class Rectangulo : public FormaGeometrica {
private:
    double base, altura;
public:
    Rectangulo(double b, double h) : base(b), altura(h) {}

    double calcularArea() const override {
        return base * altura;
    }

    double calcularPerimetro() const override {
        return 2 * (base + altura);
    }

    void mostrarInformacion() const override {
        cout << "Rectangulo -> Base: " << base << ", Altura: " << altura << ", Area: " << calcularArea() << ", Perimetro: " << calcularPerimetro() << endl;
    }
};

// Triangulo
class Triangulo : public FormaGeometrica {
private:
    double lado1, lado2, lado3;
public:
    Triangulo(double l1, double l2, double l3) : lado1(l1), lado2(l2), lado3(l3) {}

    double calcularArea() const override {
        double s = (lado1 + lado2 + lado3) / 2;
        return sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    double calcularPerimetro() const override {
        return lado1 + lado2 + lado3;
    }

    void mostrarInformacion() const override {
        cout << "Triangulo -> Lados: " << lado1 << ", " << lado2 << ", " << lado3 << ", Area: " << calcularArea() << ", Perimetro: " << calcularPerimetro() << endl;
    }
};

int main() {
    const int max = 10;
    FormaGeometrica* formas[max] = {nullptr}; // Arreglo de punteros a formas geométricas

    int contador = 0; // Contador de formas agregadas

    // Menú de opciones
    cout << "Sistema de Gestion de Formas Geometricas" << endl;
    cout << "1. Agregar Circulo" << endl;
    cout << "2. Agregar Rectangulo" << endl;
    cout << "3. Agregar Triangulo" << endl;
    cout << "4. Mostrar Informacion de Todas las Formas" << endl;
    cout << "5. Salir" << endl;

    int opcion;
    do {
        cout << "Seleccione una opcion: ";
        cin >> opcion;

        switch (opcion) {
            case 1: {
                if (contador < max) {
                    double radio;
                    cout << "Ingrese el radio del circulo: ";
                    cin >> radio;
                    formas[contador] = new Circulo(radio);
                    contador++;
                } else {
                    cout << "No se pueden agregar mas formas. Limite alcanzado." << endl;
                }
                break;
            }
            case 2: {
                if (contador < max) {
                    double base, altura;
                    cout << "Ingrese la base y la altura del rectangulo: ";
                    cin >> base >> altura;
                    formas[contador] = new Rectangulo(base, altura);
                    contador++;
                } else {
                    cout << "No se pueden agregar mas formas. Limite alcanzado." << endl;
                }
                break;
            }
            case 3: {
                if (contador < max) {
                    double lado1, lado2, lado3;
                    cout << "Ingrese los tres lados del triangulo: ";
                    cin >> lado1 >> lado2 >> lado3;
                    formas[contador] = new Triangulo(lado1, lado2, lado3);
                    contador++;
                } else {
                    cout << "No se pueden agregar mas formas. Limite alcanzado." << endl;
                }
                break;
            }
            case 4:
                cout << "\nInformacion de Formas Geometricas Agregadas:" << endl;
                for (int i = 0; i < contador; i++) {
                    formas[i]->mostrarInformacion();
                }
                break;
            case 5:
                cout << "Saliendo..." << endl;
                break;
            default:
                cout << "Opcion no valida. Intente de nuevo." << endl;
        }
    } while (opcion != 5);

    // Liberar memoria de las formas creadas
    for (int i = 0; i < contador; i++) {
        delete formas[i];
    }

    return 0;
}
//EJERCICIO 3
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

#include <iostream>
#include <string>
#include <vector>
using namespace std;
struct Contacto {
    string nombre;
    string telefono;
    string email;
};

int main() {
    vector<Contacto> agenda;

    int opcion;
    do {
        cout << "\nMENU\n";
        cout << "1. Agregar nuevo contacto\n";
        cout << "2. Buscar contacto por nombre\n";
        cout << "3. Actualizar información de un contacto\n";
        cout << "4. Mostrar lista de contactos ordenada alfabéticamente\n";
        cout << "5. Salir\n";
        cout << "Ingrese una opción: ";
        cin >> opcion;

        switch (opcion) {
            case 1: {
                Contacto nuevoContacto;
                cout << "Ingrese el nombre del contacto: ";
                cin >> nuevoContacto.nombre;
                cout << "Ingrese el número de teléfono: ";
                cin >> nuevoContacto.telefono;
                cout << "Ingrese la dirección de correo electrónico: ";
                cin >> nuevoContacto.email;

                agenda.push_back(nuevoContacto);
                break;
            }
            case 2: {
                string nombreBusqueda;
                cout << "Ingrese el nombre del contacto a buscar: ";
                cin >> nombreBusqueda;

                bool encontrado = false;
                for (const auto& contacto : agenda) {
                    if (contacto.nombre == nombreBusqueda) {
                        cout << "Contacto encontrado:\n";
                        cout << "Nombre: " << contacto.nombre << "\n";
                        cout << "Teléfono: " << contacto.telefono << "\n";
                        cout << "Email: " << contacto.email << "\n";
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    cout << "Contacto no encontrado.\n";
                }
                break;
            }
            case 3: {
                string nombreActualizar;
                cout << "Ingrese el nombre del contacto a actualizar: ";
                cin >> nombreActualizar;

                bool encontrado = false;
                for (auto& contacto : agenda) {
                    if (contacto.nombre == nombreActualizar) {
                        cout << "Ingrese el nuevo número de teléfono: ";
                        cin >> contacto.telefono;
                        cout << "Ingrese la nueva dirección de correo electrónico: ";
                        cin >> contacto.email;
                        cout << "Información actualizada.\n";
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    cout << "Contacto no encontrado.\n";
                }
                break;
            }
            case 4: {
                cout << "Lista de contactos ordenada alfabéticamente:\n";
                for (const auto& contacto : agenda) {
                    cout << "Nombre: " << contacto.nombre << " - Teléfono: " << contacto.telefono << " - Email: " << contacto.email << "\n";
                }
                break;
            }
            case 5:
                cout << "Saliendo del programa.\n";
                break;
            default:
                cout << "Opción no válida.\n";
                break;
        }
    } while (opcion != 5);

    return 0;
}



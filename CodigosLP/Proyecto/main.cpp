#include <iostream>
using namespace std;
#include "Material.h"
#include "Libros.h"
#include "Revistas.h"
#include "DVDs.h"
#include "Coleccion.h"
#include "Cliente.h"
#include "Prestamo.h"

// Función para mostrar el menú y obtener la opción seleccionada por el usuario
int mostrar_menu() {
    int opcion;
    cout<<"**************************************"<<endl;
    cout << "Menu:\n";
    cout << "1. Agregar Libro\n";
    cout << "2. Agregar Revista\n";
    cout << "3. Agregar DVD\n";
    cout << "4. Mostrar Coleccion\n";
    cout << "5. Buscar Material\n";
    cout << "6. Eliminar Material\n";
    cout << "7. Salir\n";
    cout<<"**************************************"<<endl;
    cout << "Seleccione una opcion: "; cin >> opcion;
    return opcion;
}

int main() {
    // Crear una colección de materiales
    Coleccion<Material> coleccion;

    int opcion;
    do {
        // Mostrar el menú y obtener la opción del usuario
        opcion = mostrar_menu();

        switch(opcion) {
            case 1: {
                // Agregar Libro
                string titulo, autor, fecha;
                int codigo, cant_libros;
                cout << "Ingrese el titulo del libro: "; cin >> titulo;
                cout << "Ingrese el autor del libro: "; cin >> autor;
                cout << "Ingrese el codigo del libro: "; cin >> codigo;
                cout << "Ingrese la fecha de publicacion del libro: "; cin >> fecha;
                cout << "Ingrese la cantidad de libros: "; cin >> cant_libros;
                // Crear un objeto libro y agregarlo a la colección
                Libros* libro = new Libros(titulo, autor, codigo, fecha, cant_libros);
                coleccion.agregar_material(libro);
                break;
            }
            case 2: {
                // Agregar Revista
                string titulo, autor, fecha, editorial;
                int codigo, cant_revistas;
                cout << "Ingrese el titulo de la revista: "; cin >> titulo;
                cout << "Ingrese el autor de la revista: "; cin >> autor;
                cout << "Ingrese el codigo de la revista: "; cin >> codigo;
                cout << "Ingrese la fecha de publicacion de la revista: "; cin >> fecha;
                cout << "Ingrese la cantidad de revistas: "; cin >> cant_revistas;
                cout << "Ingrese la editorial de la revista: "; cin >> editorial;
                // Crear un nuevo objeto revista y agregarlo a la colección
                Revistas* revista = new Revistas(titulo, autor, codigo, fecha, cant_revistas, editorial);
                coleccion.agregar_material(revista);
                break;
            }
            case 3: {
                // Agregar DVD
                string titulo, autor, fecha;
                int codigo, cant_dvd;
                cout << "Ingrese el titulo del DVD: "; cin >> titulo;
                cout << "Ingrese el autor del DVD: "; cin >> autor;
                cout << "Ingrese el codigo del DVD: "; cin >> codigo;
                cout << "Ingrese la fecha de publicacion del DVD: "; cin >> fecha;
                cout << "Ingrese la cantidad de DVDs: "; cin >> cant_dvd;
                // Crear un nuevo objeto DVD y agregarlo a la colección
                DVDs* dvd = new DVDs(titulo, autor, codigo, fecha, cant_dvd);
                coleccion.agregar_material(dvd);
                break;
            }
            case 4: {
                // Mostrar Colección
                coleccion.mostrar_coleccion();
                break;
            }
            case 5: {
                // Buscar Material
                int codigo;
                cout << "Ingrese el codigo del material a buscar: "; cin >> codigo;
                Material* material = coleccion.buscar_material(codigo);
                if (material) {
                    material->mostrarDetalles();
                } else {
                    cout << "Material no encontrado." << endl;
                }
                break;
            }
            case 6: {
                // Eliminar Material
                int codigo;
                cout << "Ingrese el codigo del material a eliminar: "; cin >> codigo;
                Material* material = coleccion.buscar_material(codigo);
                if (material) {
                    coleccion.borrar_material(material);
                    cout << "Material eliminado correctamente." << endl;
                } else {
                    cout << "Material no encontrado." << endl;
                }
                break;
            }
            case 7: {
                // Salir
                cout << "Saliendo del programa...\n";
                break;
            }
            default: {
                cout << "Opcion no valida.";
                break;
            }
        }
    } while (opcion != 7); // Repetir hasta que el usuario seleccione salir

    return 0;
}
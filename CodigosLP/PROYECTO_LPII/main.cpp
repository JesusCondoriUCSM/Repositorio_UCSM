#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <fstream>

#include "ClienteyPrestamo.h"
#include "Material.h"
#include "MaterialAudiovisual.h"
#include "Libros.h"
#include "Revistas.h"
#include "DVDs.h"
#include "CDs.h"
#include "Coleccion.h"
#include "BaseDatos.h"
#include "Menu.h"

using namespace std;

int main() {
    // Objetos para almacenar colecciones
    Coleccion<Libros> libros_colecc;
    Coleccion<Revistas> revistas_colecc;
    Coleccion<DVDs> dvds_colecc;
    Coleccion<CDs> cds_colecc;
    int op = 0;
    while (op != 3) {
        // Menú principal
        int op;
        cout << "*****************************************" << endl;
        cout << "Bienvenido a la Biblioteca" << endl;
        cout << "1. Materiales (Coleccion)" << endl;
        cout << "2. Prestamos" << endl;
        cout << "3. Salir" << endl;
        cout << "*****************************************" << endl;
        cout << "Opcion: "; cin >> op;

        switch (op) {
            case 1: {
                int opc_mat;
                cout << "*****************************************" << endl;
                cout << "Materiales (Coleccion)" << endl;
                cout << "1. Agregar Material a la Coleccion" << endl;
                cout << "2. Buscar Material en la Coleccion" << endl;
                cout << "3. Borrar Material en la Coleccion" << endl;
                cout << "4. Mostrar Coleccion" << endl;
                cout << "5. Regresar al Menu Principal" << endl;
                cout << "*****************************************" << endl;
                cout << "Opcion: "; cin >> opc_mat;

                switch (opc_mat) {
                    case 1: {
                        // Agregar Material a la Coleccion
                        int opc_mat1;
                        cout << "*****************************************" << endl;
                        cout << "Agregar Material a la Coleccion" << endl;
                        cout << "1. Libro" << endl;
                        cout << "2. Revista" << endl;
                        cout << "3. DVD" << endl;
                        cout << "4. CD" << endl;
                        cout << "*****************************************" << endl;
                        cout << "Opcion: "; cin >> opc_mat1;

                        switch (opc_mat1) {
                            case 1: {
                                // Agregar Libro
                                string titulo, autor, editorial, idioma;
                                int codigo, anio;
                                cout << "**************************************************************" << endl;
                                cout << "Agregar Libro a la Coleccion" << endl;
                                cout << "1. Ingrese el titulo del libro: "; cin >> titulo;
                                cout << "2. Ingrese el autor del libro: "; cin >> autor;
                                cout << "3. Ingrese la editorial del libro: "; cin >> editorial;
                                cout << "4. Ingrese el idioma del libro: "; cin >> idioma;
                                cout << "5. Ingrese el codigo del libro: "; cin >> codigo;
                                cout << "6. Ingrese el anio de publicacion del libro: "; cin >> anio;
                                cout << "**************************************************************" << endl;
                                Libros* libro = new Libros(titulo, autor, codigo, editorial, anio, idioma);
                                libros_colecc.agregar_material(libro);
                                break;
                            }

                            case 2: {
                                // Agregar Revista
                                string titulo, autor, editorial, anio;
                                int codigo, num_edi;
                                cout << "**************************************************************" << endl;
                                cout << "Agregar Revista a la Coleccion" << endl;
                                cout << "1. Ingrese el titulo de la revista: "; cin >> titulo;
                                cout << "2. Ingrese el autor de la revista: "; cin >> autor;
                                cout << "3. Ingrese la editorial de la revista: "; cin >> editorial;
                                cout << "4. Ingrese el numero de edicion: "; cin >> num_edi;
                                cout << "5. Ingrese el codigo de la revista: "; cin >> codigo;
                                cout << "6. Ingrese el anio de publicacion de la revista: "; cin >> anio;
                                cout << "**************************************************************" << endl;
                                Revistas* revista = new Revistas(titulo, autor, codigo, editorial, num_edi, anio);
                                revistas_colecc.agregar_material(revista);
                                break;
                            }

                            case 3: {
                                // Agregar DVD
                                string titulo, autor, idioma, genero, resol, form_audio;
                                int codigo, anio;
                                float duracion;
                                cout << "**************************************************************" << endl;
                                cout << "Agregar DVD a la Coleccion" << endl;
                                cout << "1. Ingrese el titulo del DVD: "; cin >> titulo;
                                cout << "2. Ingrese el autor del DVD: "; cin >> autor;
                                cout << "3. Ingrese el codigo del DVD: "; cin >> codigo;
                                cout << "4. Ingrese el idioma del DVD: "; cin >> idioma;
                                cout << "5. Ingrese el genero del DVD: "; cin >> genero;
                                cout << "6. Ingrese la duracion del DVD: "; cin >> duracion;
                                cout << "7. Ingrese el anio de publicacion del DVD: "; cin >> anio;
                                cout << "8. Ingrese la resolucion del DVD: "; cin >> resol;
                                cout << "9. Ingrese el formato de audio del DVD: "; cin >> form_audio;
                                cout << "**************************************************************" << endl;
                                DVDs* dvd = new DVDs(titulo, autor, codigo, idioma, genero, duracion, anio, resol, form_audio);
                                dvds_colecc.agregar_material(dvd);
                                break;
                            }

                            case 4: {
                                // Agregar CD
                                string titulo, autor, idioma, genero, resol, form_audio;
                                int codigo, anio;
                                float duracion;
                                cout << "**************************************************************" << endl;
                                cout << "Agregar CD a la Coleccion" << endl;
                                cout << "1. Ingrese el titulo del CD: "; cin >> titulo;
                                cout << "2. Ingrese el autor del CD: "; cin >> autor;
                                cout << "3. Ingrese el codigo del CD: "; cin >> codigo;
                                cout << "4. Ingrese el idioma del CD: "; cin >> idioma;
                                cout << "5. Ingrese el genero del CD: "; cin >> genero;
                                cout << "6. Ingrese la duracion del CD: "; cin >> duracion;
                                cout << "7. Ingrese el anio de publicacion del CD: "; cin >> anio;
                                cout << "8. Ingrese la resolucion del CD: "; cin >> resol;
                                cout << "9. Ingrese el formato de audio del CD: "; cin >> form_audio;
                                cout << "**************************************************************" << endl;
                                CDs* cd = new CDs(titulo, autor, codigo, idioma, genero, duracion, anio, resol, form_audio);
                                cds_colecc.agregar_material(cd);
                                break;
                            }
                        }
                        break;
                    }

                    case 2: {
                        // Buscar material
                        int opc_mat2;
                        cout << "*****************************************" << endl;
                        cout << "Buscar Material en la Coleccion" << endl;
                        cout << "1. Buscar por Codigo" << endl;
                        cout << "*****************************************" << endl;
                        cout << "Opcion: "; cin >> opc_mat2;

                        if (opc_mat2 == 1) {
                            int opc_mat2_2;
                            cout << "*****************************************" << endl;
                            cout << "1. Buscar Libro" << endl;
                            cout << "2. Buscar Revista" << endl;
                            cout << "3. Buscar DVD" << endl;
                            cout << "4. Buscar CD" << endl;
                            cout << "*****************************************" << endl;

                            cout << "Opcion: "; cin >> opc_mat2_2;

                            int codigo;
                            switch (opc_mat2_2) {
                                case 1: {
                                    // Buscar libro por Codigo
                                    cout << "Ingrese el Codigo del Libro a Buscar: "; cin >> codigo;
                                    Libros* libro = libros_colecc.buscar_material(codigo);
                                    if (libro != nullptr) {
                                        libro->mostrarDetalles();
                                    } else {
                                        cout << "No se encontro el libro con el codigo " << codigo << endl;
                                    }
                                    break;
                                }
                                case 2: {
                                    // Buscar Revista por Codigo
                                    cout << "Ingrese el Codigo de la Revista a Buscar: "; cin >> codigo;
                                    Revistas* revista = revistas_colecc.buscar_material(codigo);
                                    if (revista != nullptr) {
                                        revista->mostrarDetalles();
                                    } else {
                                        cout << "No se encontro la revista con el codigo " << codigo << endl;
                                    }
                                    break;
                                }
                                case 3: {
                                    // Buscar DVD por Codigo
                                    cout << "Ingrese el Codigo del DVD a Buscar: "; cin >> codigo;
                                    DVDs* dvd = dvds_colecc.buscar_material(codigo);
                                    if (dvd != nullptr) {
                                        dvd->mostrarDetalles();
                                    } else {
                                        cout << "No se encontro el DVD con el codigo " << codigo << endl;
                                    }
                                    break;
                                }
                                case 4: {
                                    // Buscar CD por Codigo
                                    cout << "Ingrese el Codigo del CD a Buscar: "; cin >> codigo;
                                    CDs* cd = cds_colecc.buscar_material(codigo);
                                    if (cd != nullptr) {
                                        cd->mostrarDetalles();
                                    } else {
                                        cout << "No se encontro el CD con el codigo " << codigo << endl;
                                    }
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    case 3: {
                        // Borrar material
                        int opc_mat3;
                        cout << "*****************************************" << endl;
                        cout << "Borrar Material en la Coleccion" << endl;
                        cout << "1. Borrar por Codigo" << endl;
                        cout << "2. Regresar al Menu Materiales" << endl;
                        cout << "*****************************************" << endl;
                        cout << "Opcion: "; cin >> opc_mat3;

                        if (opc_mat3 == 1) {
                            int opc_mat3_1;
                            cout << "*****************************************" << endl;
                            cout << "1. Borrar Libro" << endl;
                            cout << "2. Borrar Revista" << endl;
                            cout << "3. Borrar DVD" << endl;
                            cout << "4. Borrar CD" << endl;
                            cout << "*****************************************" << endl;

                            cout << "Opcion: "; cin >> opc_mat3_1;

                            int codigo;
                            switch (opc_mat3_1) {
                                case 1: {
                                    // Borrar Libro por Codigo
                                    cout << "Ingrese el Codigo del Libro a Borrar: "; cin >> codigo;
                                    libros_colecc.borrar_material(codigo);
                                    break;
                                }
                                case 2: {
                                    // Borrar Revista por Codigo
                                    cout << "Ingrese el Codigo de la Revista a Borrar: "; cin >> codigo;
                                    revistas_colecc.borrar_material(codigo);
                                    break;
                                }
                                case 3: {
                                    // Borrar DVD por Codigo
                                    cout << "Ingrese el Codigo del DVD a Borrar: "; cin >> codigo;
                                    dvds_colecc.borrar_material(codigo);
                                    break;
                                }
                                case 4: {
                                    // Borrar CD por Codigo
                                    cout << "Ingrese el Codigo del CD a Borrar: "; cin >> codigo;
                                    cds_colecc.borrar_material(codigo);
                                    break;
                                }
                            }
                        }
                        break;
                    }

                    case 4: {
                        int opc_mat4;
                        cout << "*****************************************" << endl;
                        cout << "Mostrar Coleccion" << endl;
                        cout << "1. Mostrar Libros" << endl;
                        cout << "2. Mostrar Revistas" << endl;
                        cout << "3. Mostrar DVDs" << endl;
                        cout << "4. Mostrar CDs" << endl;
                        cout << "*****************************************" << endl;
                        cout << "Opcion: "; cin >> opc_mat4;
                        switch (opc_mat4) {
                            case 1: {
                                // Mostrar Libros
                                libros_colecc.mostrar_coleccion(); break;
                            }
                            case 2: {
                                // Mostrar Revistas
                                revistas_colecc.mostrar_coleccion(); break;
                            }
                            case 3: {
                                // Mostrar DVDs
                                dvds_colecc.mostrar_coleccion(); break;
                            }
                            case 4: {
                                // Mostrar CDs
                                cds_colecc.mostrar_coleccion(); break;
                            }
                        }
                        break;
                    }
                }
                break;
            }

            case 2:
                
                break;

            case 3:
                // Salir del programa
                cout << "Saliendo del programa..." << endl;
                return 0;
                break;

            default:
                cout << "Opcion no valida. Por favor, ingrese una opcion valida." << endl;
        }
    }

    return 0;
}

#ifndef MENU_H
#define MENU_H

#include <iostream>
using namespace std;

class Menu{
    public:
        //metodos
        int principal(){
            int op;
            cout<<"*****************************************"<<endl;
            cout << "Bienvenido a la Biblioteca" << endl;
            cout << "1. Materiales(Coleccion)"<<endl;
            cout << "2. Prestamos"<<endl;
            cout << "3. Salir"<<endl;
            cout<<"*****************************************"<<endl;
            cout<<"Opcion: "; cin>>op;
            return op;
        }

        int materiales(){
            int op;
            cout<<"*****************************************"<<endl;
            cout << "Materiales(Coleccion)" << endl;
            cout << "1. Agregar Material a la Coleccion"<<endl;
            cout << "2. Buscar Material en la Coleccion"<<endl;
            cout << "3. Borrar Material en la Coleccion"<<endl;
            cout << "4. Mostrar Coleccion"<<endl;
            cout << "5. Regresar al Menu Principal"<<endl;
            cout<<"*****************************************"<<endl;
            cout<<"Opcion: "; cin>>op;
            return op;
        }

        int materiales1(){
            int op;
            cout<<"*****************************************"<<endl;
            cout << "Agregar Material a la Coleccion" << endl;
            cout << "1. Libro"<<endl;
            cout << "2. Revista"<<endl;
            cout << "3. DVD"<<endl;
            cout << "4. CD"<<endl;
            cout << "5. Regresar al Menu Materiales"<<endl;
            cout<<"*****************************************"<<endl;
            cout<<"Opcion: "; cin>>op;
            return op;
        }

        void materiales1_1(){            
            cout<<"**************************************************************"<<endl;
            cout << "Agregar Libro a la Coleccion" << endl;
            cout << "1. Ingrese el titulo del libro " << endl;
            cout << "2. Ingrese el autor del libro "<< endl;
            cout << "3. Ingrese la editorial del libro "<< endl;
            cout << "4. Ingrese el idioma del libro "<< endl;
            cout << "5. Ingrese el codigo del libro "<< endl;
            cout << "6. Ingrese el año de publicacion del libro "<< endl;
            cout<<"**************************************************************"<<endl;
        }

        void materiales1_2(){
            cout<<"**************************************************************"<<endl;
            cout << "Agregar Revista a la Coleccion" << endl;
            cout << "1. Ingrese el titulo de la revista " << endl;
            cout << "2. Ingrese el autor de la revista "<< endl;
            cout << "3. Ingrese la editorial de la revista "<< endl;
            cout << "4. Ingrese el numero de edicion "<< endl;
            cout << "5. Ingrese el codigo de la revista "<< endl;
            cout << "6. Ingrese el anio de publicacion de la revista "<< endl;
            cout<<"**************************************************************"<<endl;
        }

        void materiales1_3(){
            cout<<"**************************************************************"<<endl;
            cout << "Agregar DVD a la Coleccion" << endl;
            cout << "1. Ingrese el titulo del DVD " << endl;
            cout << "2. Ingrese el autor del DVD "<< endl;
            cout << "3. Ingrese el codigo del DVD "<< endl;
            cout << "4. Ingrese el idioma del DVD "<< endl;
            cout << "5. Ingrese el genero del DVD "<< endl;
            cout << "6. Ingrese la duracion del DVD "<< endl;
            cout << "7. Ingrese el anio de publicacion del DVD "<< endl;
            cout << "8. Ingrese la resolucion del DVD "<< endl;
            cout << "9. Ingrese el formato de audio del DVD"<< endl;
            cout<<"**************************************************************"<<endl;
        }

        void materiales1_4(){
            cout<<"**************************************************************"<<endl;
            cout << "Agregar CD a la Coleccion" << endl;
            cout << "1. Ingrese el titulo del CD " << endl;
            cout << "2. Ingrese el autor del CD "<< endl;
            cout << "3. Ingrese el codigo del CD "<< endl;
            cout << "4. Ingrese el idioma del CD "<< endl;
            cout << "5. Ingrese el genero del CD "<< endl;
            cout << "6. Ingrese la duracion del CD "<< endl;
            cout << "7. Ingrese el anio de publicacion del CD "<< endl;
            cout << "8. Ingrese el la resolucion del CD "<< endl;
            cout << "9. Ingrese el Formato de audio del CD "<< endl;
            cout<<"**************************************************************"<<endl;
        }

        int materiales2(){
            int op;
            cout<<"*****************************************"<<endl;
            cout << "Buscar Material en la Coleccion" << endl;
            cout << "1. Buscar por Titulo"<<endl;
            cout << "2. Regresar al Menu Materiales"<<endl;
            cout<<"*****************************************"<<endl;
            cout<<"Opcion: "; cin>>op;
            return op;
        }

        int materiales3(){
            int op;
            cout<<"*****************************************"<<endl;
            cout << "Borrar Material en la Coleccion" << endl;
            cout << "1. Borrar por Codigo"<<endl;
            cout << "2. Regresar al Menu Materiales"<<endl;
            cout<<"*****************************************"<<endl;
            cout<<"Opcion: "; cin>>op;
            return op;
        }

        int materales4(){
            int op;
            cout<<"*****************************************"<<endl;
            cout << "Mostrar Coleccion" << endl;
            cout << "1. Mostrar todos los Materiales"<<endl;
            cout << "2. Regresar al Menu Materiales"<<endl;
            cout<<"*****************************************"<<endl;
            cout<<"Opcion: "; cin>>op;
            return op;
        }

        int Prestamos(){
            int op;
            cout<<"*****************************************"<<endl;
            cout << "Prestamos" << endl;
            cout << "1. Realizar Prestamo"<<endl;
            cout << "2. Devolver Material Prestado"<<endl;
            cout << "3. Mostrar Prestamos"<<endl;
            cout << "4. Regresar al Menu Principal"<<endl;
            cout<<"*****************************************"<<endl;
            cout<<"Opcion: "; cin>>op;
            return op;
        }

};


#endif
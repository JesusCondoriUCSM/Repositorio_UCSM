#include <iostream>
#include <vector>
using namespace std;

class Autor {
    protected:
        //Atributos
        string nombre;
        string apellido;
    public:
        //Constructor(Inicializa el nombre y apellido del autor)
        Autor(string n, string a) : nombre(n), apellido(a) {}
        // Método que devuelve el nombre completo del autor
        string get_nombre_apellido(){return nombre + " " + apellido;}
        
};

class Material {
    protected:
    //Atributos
        string titulo;
        Autor* autor; // Puntero a un objeto Autor
        int codigo;
    public:
        // Constructor
        Material(string t, Autor* a, int c) : titulo(t), autor(a), codigo(c) {}
        // Método virtual que muestra los detalles del material
        virtual void mostrarDetalles(){
            cout << "Titulo: " << titulo << endl;
            cout << "Autor: " << autor->get_nombre_apellido() << endl;
            cout << "Codigo: " << codigo << endl;
        }
        //Destructor virtual
        /*Asegura que cuando se elimina un objeto de una clase 
        derivada a través de un puntero a la clase base, 
        el destructor de la clase derivada se llame correctamente.*/
        virtual ~Material(){}
};

class Libros : public Material {
    protected:
    //Atributos
        string fecha;
    public:
        // Constructor
        Libros(string t, Autor* a, int c, string f) : Material(t, a, c), fecha(f) {}
        // Método sobrescrito
        void mostrarDetalles(){
            //Refinamiento
            Material::mostrarDetalles(); // Llama al método de la clase base
            cout << "Fecha: " << fecha << endl;
        }
};

class Revistas : public Material {
    protected:
    //Atributos
        string fecha;
        string editorial;
    public:
        // Constructor
        Revistas(string t, Autor* a, int c, string f, string e) : Material(t, a, c), fecha(f), editorial(e) {}
        // Método sobrescrito que muestra los detalles de la revista
        void mostrarDetalles(){
            //Refinamiento
            Material::mostrarDetalles(); // Llama al método de la clase base
            cout << "Fecha: " << fecha << endl;
            cout << "Editorial: " << editorial << endl;
        }
};

class DVDs : public Material {
    protected:
    //Atributos
        string fecha;
    public:
        // Constructor
        DVDs(string t, Autor* a, int c, string f) : Material(t, a, c), fecha(f) {}
        // Método sobrescrito que muestra los detalles del DVD
        void mostrarDetalles(){
            //Refinamiento
            Material::mostrarDetalles(); // Llama al método de la clase base
            cout << "Fecha: " << fecha << endl;
        }
};
/*class Sistema{
    protected:
        vector<class Libros*> Libros_bib;
        vector<class Revistas*> Revistas_bib;
        vector<class DVDs*> DVDs_bib;
    public:
    //Metodos para agregar libros,revistas y DVDs
        void agregar_material_libros(Libros* Libro){Libros_bib.push_back(Libro);}
        void agregar_material_Revistas(Revistas* Revista){Revistas_bib.push_back(Revista);}
        void agregar_material_libros(DVDs* DVD){DVDs_bib.push_back(DVD);}
    //Metodos para mostrar detalles de todos los materiales(libros,revistas o DVDs)
        void mostrar_material_libros(){
            int i = 0;
            while(Libros_bib[i] != nullptr){
                Libros_bib[i]->mostrarDetalles();
                i++;
            }
        }
        void mostrar_material_Revistas(){
            int i = 0;
            while(Revistas_bib[i] != nullptr){
                Revistas_bib[i]->mostrarDetalles();
                i++;
            }
        }
        void mostrar_material_DVDs(){
            int i = 0;
            while(DVDs_bib[i] != nullptr){
                DVDs_bib[i]->mostrarDetalles();
                i++;
            }
        }

};*/

int main() {
    // Arreglo de punteros a objetos Material
    Material* arreglo[3];
    // Creación de autores
    Autor autor1("Juan", "Flores");
    Autor autor2("Pedro", "Garcia");
    Autor autor3("Maria", "Lopez");
    // Inicialización del arreglo con diferentes tipos de materiales
    arreglo[0] = new Libros("Titulo1", &autor1, 1234, "2004");
    arreglo[1] = new Revistas("Revista1", &autor2, 5678, "Mayo 2024", "Editorial Ejemplo");
    arreglo[2] = new DVDs("DVD1", &autor3, 9101, "2010");

    // Mostrar detalles de todos los materiales en el arreglo(Polimorfismo)
    for (int i = 0; i < 3; ++i) {
        arreglo[i]->mostrarDetalles();
        cout << endl;
    }

    // Liberar memoria(evitar fugaz de memoria)
    for (int i = 0; i < 3; ++i) {
        delete arreglo[i];
    }

    return 0;
}

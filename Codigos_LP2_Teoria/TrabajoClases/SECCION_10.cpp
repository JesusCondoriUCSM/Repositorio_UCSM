#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Plantilla de clase Producto para representar diferentes tipos de productos
template<typename T>
class Producto {
protected:
    string nombre;
    double precio;
    string codigo;
    int cantidadDisponible;

public:
    Producto(string _nombre, double _precio, string _codigo, int _cantidad)
        : nombre(_nombre), precio(_precio), codigo(_codigo), cantidadDisponible(_cantidad) {}

    virtual void mostrarDetalles() const = 0;

    string getNombre() const {
        return nombre;
    }
    void setNombre(const string& _nombre) {
        nombre = _nombre;
    }

    double getPrecio() const {
        return precio;
    }
    void setPrecio(double _precio) {
        precio = _precio;
    }

    string getCodigo() const {
        return codigo;
    }
    void setCodigo(const string& _codigo) {
        codigo = _codigo;
    }

    int getCantidadDisponible() const {
        return cantidadDisponible;
    }
    void setCantidadDisponible(int _cantidad) {
        cantidadDisponible = _cantidad;
    }
};

// Especialización de la plantilla para Alimento
class Alimento : public Producto<Alimento> {
private:
    string fechaVencimiento;

public:
    Alimento(string _nombre, double _precio, string _codigo, int _cantidad, string _fechaVencimiento)
        : Producto(_nombre, _precio, _codigo, _cantidad), fechaVencimiento(_fechaVencimiento) {}

    void mostrarDetalles() const override {
        cout << "Alimento: " << nombre << endl;
        cout << "Precio: " << precio << endl;
        cout << "Codigo: " << codigo << endl;
        cout << "Cantidad disponible: " << cantidadDisponible << endl;
        cout << "Fecha de vencimiento: " << fechaVencimiento << endl;
        cout << "--------------------------" << endl;
    }
};

// Especialización de la plantilla para Electronico
class Electronico : public Producto<Electronico> {
private:
    string marca;
    string modelo;

public:
    Electronico(string _nombre, double _precio, string _codigo, int _cantidad, string _marca, string _modelo)
        : Producto(_nombre, _precio, _codigo, _cantidad), marca(_marca), modelo(_modelo) {}

    void mostrarDetalles() const override {
        cout << "Electronico: " << nombre << endl;
        cout << "Marca: " << marca << endl;
        cout << "Modelo: " << modelo << endl;
        cout << "Precio: " << precio << endl;
        cout << "Codigo: " << codigo << endl;
        cout << "Cantidad disponible: " << cantidadDisponible << endl;
        cout << "--------------------------" << endl;
    }
};

// Especialización de la plantilla para Ropa
class Ropa : public Producto<Ropa> {
private:
    string talla;
    string material;

public:
    Ropa(string _nombre, double _precio, string _codigo, int _cantidad, string _talla, string _material)
        : Producto(_nombre, _precio, _codigo, _cantidad), talla(_talla), material(_material) {}

    void mostrarDetalles() const override {
        cout << "Ropa: " << nombre << endl;
        cout << "Talla: " << talla << endl;
        cout << "Material: " << material << endl;
        cout << "Precio: " << precio << endl;
        cout << "Codigo: " << codigo << endl;
        cout << "Cantidad disponible: " << cantidadDisponible << endl;
        cout << "--------------------------" << endl;
    }
};

// Plantilla de clase Inventario
template<typename T>
class Inventario {
private:
    vector<T*> productos;

public:
    Inventario() {}

    ~Inventario() {
        for (auto& producto : productos) {
            delete producto;
        }
        productos.clear();
    }

    void agregarProducto(T* producto) {
        productos.push_back(producto);
    }

    void eliminarProducto(const string& codigo) {
        for (auto it = productos.begin(); it != productos.end(); ++it) {
            if ((*it)->getCodigo() == codigo) {
                delete *it;
                productos.erase(it);
                break;
            }
        }
    }

    T* buscarProducto(const string& codigo) {
        for (auto& producto : productos) {
            if (producto->getCodigo() == codigo) {
                return producto;
            }
        }
        return nullptr;
    }

    void listarProductos() {
        for (auto& producto : productos) {
            producto->mostrarDetalles();
        }
    }

    // Método para actualizar información de un producto existente
    void actualizarProducto(const string& codigo) {
        T* producto = buscarProducto(codigo);
        if (producto) {
            cout << "Seleccione el dato a actualizar:" << endl;
            cout << "1. Nombre" << endl;
            cout << "2. Precio" << endl;
            cout << "3. Código" << endl;
            // Agregar más opciones según sea necesario

            int opcion;
            cin >> opcion;
            cin.ignore();

            switch (opcion) {
                case 1: {
                    string nuevoNombre;
                    cout << "Ingrese el nuevo nombre: ";
                    getline(cin, nuevoNombre);
                    producto->setNombre(nuevoNombre);
                    cout << "Nombre actualizado correctamente." << endl;
                    break;
                }
                case 2: {
                    double nuevoPrecio;
                    cout << "Ingrese el nuevo precio: ";
                    cin >> nuevoPrecio;
                    cin.ignore(); // Ignorar el salto de línea pendiente en el buffer
                    producto->setPrecio(nuevoPrecio);
                    cout << "Precio actualizado correctamente." << endl;
                    break;
                }
                case 3: {
                    string nuevoCodigo;
                    cout << "Ingrese el nuevo código: ";
                    getline(cin, nuevoCodigo);
                    producto->setCodigo(nuevoCodigo);
                    cout << "Código actualizado correctamente." << endl;
                    break;
                }
                default:
                    cout << "Opción inválida." << endl;
                    break;
            }
        } else {
            cout << "Producto no encontrado." << endl;
        }
    }
};

void mostrarMenu() {
    cout << "======= MENU =======" << endl;
    cout << "1. Agregar producto" << endl;
    cout << "2. Eliminar producto" << endl;
    cout << "3. Buscar producto por código" << endl;
    cout << "4. Listar todos los productos" << endl;
    cout << "5. Actualizar información de un producto" << endl;
    cout << "6. Salir" << endl;
    cout << "====================" << endl;
    cout << "Seleccione una opción: ";
}

int main() {
    
    Inventario<Producto<Alimento>> inventarioAlimentos;
    Inventario<Producto<Electronico>> inventarioElectronicos;
    Inventario<Producto<Ropa>> inventarioRopa;

    int opcion;
    do {
        mostrarMenu();
        cin >> opcion;
        cin.ignore();

        switch (opcion) {
            case 1: {
                cout << "Ingrese los datos del producto:" << endl;
                string nombre, codigo, fechaVencimiento, marca, modelo, talla, material;
                double precio;
                int cantidad, tipoProducto;
                cout << "Nombre: ";
                getline(cin, nombre);
                cout << "Precio: ";
                cin >> precio;
                cin.ignore();
                cout << "Código: ";
                getline(cin, codigo);
                cout << "Cantidad disponible: ";
                cin >> cantidad;
                cin.ignore();

                cout << "Seleccione el tipo de producto:" << endl;
                cout << "1. Alimento" << endl;
                cout << "2. Electrónico" << endl;
                cout << "3. Ropa" << endl;
                cin >> tipoProducto;
                cin.ignore();

                switch (tipoProducto) {
                    case 1: {
                        cout << "Fecha de vencimiento (dd/mm/yyyy): ";
                        getline(cin, fechaVencimiento);
                        inventarioAlimentos.agregarProducto(new Alimento(nombre, precio, codigo, cantidad, fechaVencimiento));
                        break;
                    }
                    case 2: {
                        cout << "Marca: ";
                        getline(cin, marca);
                        cout << "Modelo: ";
                        getline(cin, modelo);
                        inventarioElectronicos.agregarProducto(new Electronico(nombre, precio, codigo, cantidad, marca, modelo));
                        break;
                    }
                    case 3: {
                        cout << "Talla: ";
                        getline(cin, talla);
                        cout << "Material: ";
                        getline(cin, material);
                        inventarioRopa.agregarProducto(new Ropa(nombre, precio, codigo, cantidad, talla, material));
                        break;
                    }
                    default:
                        cout << "Opción inválida." << endl;
                        break;
                }

                break;
            }
            case 2: {
                string codigo;
                cout << "Ingrese el código del producto a eliminar: ";
                getline(cin, codigo);

                Producto<Alimento>* encontradoAlimento = inventarioAlimentos.buscarProducto(codigo);
                if (encontradoAlimento) {
                    inventarioAlimentos.eliminarProducto(codigo);
                    cout << "Alimento eliminado." << endl;
                    break;
                }

                Producto<Electronico>* encontradoElectronico = inventarioElectronicos.buscarProducto(codigo);
                if (encontradoElectronico) {
                    inventarioElectronicos.eliminarProducto(codigo);
                    cout << "Electrónico eliminado." << endl;
                    break;
                }

                Producto<Ropa>* encontradoRopa = inventarioRopa.buscarProducto(codigo);
                if (encontradoRopa) {
                    inventarioRopa.eliminarProducto(codigo);
                    cout << "Ropa eliminada." << endl;
                    break;
                }

                cout << "Producto no encontrado." << endl;
                break;
            }
            case 3: {
                string codigo;
                cout << "Ingrese el código del producto a buscar: ";
                getline(cin, codigo);

                Producto<Alimento>* encontradoAlimento = inventarioAlimentos.buscarProducto(codigo);
                if (encontradoAlimento) {
                    encontradoAlimento->mostrarDetalles();
                    break;
                }

                Producto<Electronico>* encontradoElectronico = inventarioElectronicos.buscarProducto(codigo);
                if (encontradoElectronico) {
                    encontradoElectronico->mostrarDetalles();
                    break;
                }

                Producto<Ropa>* encontradoRopa = inventarioRopa.buscarProducto(codigo);
                if (encontradoRopa) {
                    encontradoRopa->mostrarDetalles();
                    break;
                }

                cout << "Producto no encontrado." << endl;
                break;
            }
            case 4: {
                cout << "Inventario de Alimentos:" << endl;
                inventarioAlimentos.listarProductos();

                cout << "Inventario de Productos Electrónicos:" << endl;
                inventarioElectronicos.listarProductos();

                cout << "Inventario de Ropa:" << endl;
                inventarioRopa.listarProductos();
                break;
            }
            case 5: {
                string codigo;
                cout << "Ingrese el código del producto a actualizar: ";
                getline(cin, codigo);

                Producto<Alimento>* encontradoAlimento = inventarioAlimentos.buscarProducto(codigo);
                if (encontradoAlimento) {
                    inventarioAlimentos.actualizarProducto(codigo);
                    break;
                }

                Producto<Electronico>* encontradoElectronico = inventarioElectronicos.buscarProducto(codigo);
                if (encontradoElectronico) {
                    inventarioElectronicos.actualizarProducto(codigo);
                    break;
                }

                Producto<Ropa>* encontradoRopa = inventarioRopa.buscarProducto(codigo);
                if (encontradoRopa) {
                    inventarioRopa.actualizarProducto(codigo);
                    break;
                }

                cout << "Producto no encontrado." << endl;
                break;
            }
            case 6:
                break;
            default:
                cout << "Opción inválida. Intente de nuevo." << endl;
                break;
        }

    } while (opcion != 6);

    return 0;
}

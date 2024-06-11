//Ejercicio 5
ejer5 #include <iostream>
#include <string>
using namespace std;

const int MAX_PRODUCTOS = 100;

class Producto {
protected:
    string nombre;
    double precio;
    int cantidad;

public:
    Producto(const string& nombre, double precio, int cantidad)
        : nombre(nombre), precio(precio), cantidad(cantidad) {}

    virtual double calcularValorInventario() const = 0;
    virtual void aplicarDescuento(double porcentaje) = 0;

    virtual ~Producto() {}
};

class Electronico : public Producto {
public:
    Electronico(const string& nombre, double precio, int cantidad)
        : Producto(nombre, precio, cantidad) {}

    double calcularValorInventario() const override {
        return precio * cantidad;
    }

    void aplicarDescuento(double porcentaje) override {
        precio -= precio * porcentaje / 100;
    }
};

class Ropa : public Producto {
public:
    Ropa(const string& nombre, double precio, int cantidad)
        : Producto(nombre, precio, cantidad) {}

    double calcularValorInventario() const override {
        return precio * cantidad;
    }

    void aplicarDescuento(double porcentaje) override {
        precio -= precio * porcentaje / 100;
    }
};

class Alimento : public Producto {
public:
    Alimento(const string& nombre, double precio, int cantidad)
        : Producto(nombre, precio, cantidad) {}

    double calcularValorInventario() const override {
        return precio * cantidad;
    }

    void aplicarDescuento(double porcentaje) override {
        precio -= precio * porcentaje / 100;
    }
};

class GestionInventario {
private:
    Producto* productos[MAX_PRODUCTOS];
    int numProductos;

public:
    GestionInventario() : numProductos(0) {}

    void agregarProducto(Producto* producto) {
        if (numProductos < MAX_PRODUCTOS) {
            productos[numProductos++] = producto;
        } else {
            cout << "Error: El inventario está lleno." << endl;
        }
    }

    double calcularValorTotalInventario() const {
        double total = 0;
        for (int i = 0; i < numProductos; ++i) {
            total += productos[i]->calcularValorInventario();
        }
        return total;
    }

    void aplicarDescuentos(double porcentaje) {
        for (int i = 0; i < numProductos; ++i) {
            productos[i]->aplicarDescuento(porcentaje);
        }
    }

    ~GestionInventario() {
        for (int i = 0; i < numProductos; ++i) {
            delete productos[i];
        }
    }
};

void mostrarMenu() {
    cout << "1. Agregar producto" << endl;
    cout << "2. Calcular valor total del inventario" << endl;
    cout << "3. Aplicar descuento" << endl;
    cout << "4. Salir" << endl;
    cout << "Seleccione una opción: ";
}

int main() {
    GestionInventario inventario;
    int opcion;

    do {
        mostrarMenu();
        cin >> opcion;

        switch (opcion) {
            case 1: {
                int tipoProducto;
                string nombre;
                double precio;
                int cantidad;

                cout << "Seleccione el tipo de producto (1. Electronico, 2. Ropa, 3. Alimento): ";
                cin >> tipoProducto;

                cout << "Ingrese el nombre del producto: ";
                cin >> nombre;
                cout << "Ingrese el precio del producto: ";
                cin >> precio;
                cout << "Ingrese la cantidad del producto: ";
                cin >> cantidad;

                if (tipoProducto == 1) {
                    inventario.agregarProducto(new Electronico(nombre, precio, cantidad));
                } else if (tipoProducto == 2) {
                    inventario.agregarProducto(new Ropa(nombre, precio, cantidad));
                } else if (tipoProducto == 3) {
                    inventario.agregarProducto(new Alimento(nombre, precio, cantidad));
                } else {
                    cout << "Tipo de producto no válido." << endl;
                }
                break;
            }
            case 2: {
                cout << "Valor total del inventario: $" << inventario.calcularValorTotalInventario() << endl;
                break;
            }
            case 3: {
                double porcentaje;
                cout << "Ingrese el porcentaje de descuento: ";
                cin >> porcentaje;
                inventario.aplicarDescuentos(porcentaje);
                cout << "Descuento aplicado." << endl;
                break;
            }
            case 4: {
                cout << "Saliendo..." << endl;
                break;
            }
            default: {
                cout << "Opción no válida." << endl;
                break;
            }
        }
    } while (opcion != 4);

    return 0;
}

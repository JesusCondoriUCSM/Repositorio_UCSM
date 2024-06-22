#include <iostream>
#include <string>

using namespace std;

// Clase base para representar diferentes tipos de productos
class ProductoBase {
public:
    virtual ~ProductoBase() {}
    virtual void mostrarDetalles() const = 0;
};

// Clase plantilla para representar productos
template <typename Categoria>
class Producto : public ProductoBase {
private:
    string nombre;
    string codigoBarras;
    double precio;
    int cantidad;
    string categoria;
    string fechaVencimiento; // Fecha de vencimiento como string

public:
    Producto(string nombre, string codigoBarras, double precio, int cantidad, string categoria, string fechaVencimiento = "")
        : nombre(nombre), codigoBarras(codigoBarras), precio(precio), cantidad(cantidad), categoria(categoria), fechaVencimiento(fechaVencimiento) {}

    virtual ~Producto() {}

    virtual void mostrarDetalles() const override {
        cout << "Nombre: " << nombre << ", Código: " << codigoBarras << ", Precio: $" << precio
             << ", Cantidad: " << cantidad << ", Categoría: " << categoria;
        if (fechaVencimiento!="" {
            cout << ", Fecha de vencimiento: " << fechaVencimiento;
        }
        cout << endl;
    }

    string getNombre() const {
        return nombre;
    }

    string getCodigoBarras() const {
        return codigoBarras;
    }

    double getPrecio() const {
        return precio;
    }

    int getCantidad() const {
        return cantidad;
    }

    string getCategoria() const {
        return categoria;
    }

    string getFechaVencimiento() const {
        return fechaVencimiento;
    }

    void actualizarPrecio(double nuevoPrecio) {
        precio = nuevoPrecio;
    }

    void actualizarCantidad(int nuevaCantidad) {
        cantidad = nuevaCantidad;
    }

    void actualizarFechaVencimiento(string nuevaFecha) {
        fechaVencimiento = nuevaFecha;
    }
};

// Tamaño máximo para el inventario
const int MAX_PRODUCTOS = 100;

// Clase plantilla para gestionar una colección de productos
template <typename Producto>
class Inventario {
private:
    Producto* productos[MAX_PRODUCTOS];
    int numProductos;

public:
    Inventario() : numProductos(0) {}

    ~Inventario() {
        for (int i = 0; i < numProductos; ++i) {
            delete productos[i];
        }
    }
    
    void ordenarProductos(const Inventario<Producto>& inventario, bool (comparador)(Producto, Producto*)) {
    // Crear un arreglo de productos temporal para el ordenamiento
    int numProductos = inventario.getNumProductos();
    Producto* productos[MAX_PRODUCTOS];

    for (int i = 0; i < numProductos; ++i) {
        productos[i] = inventario.getProducto(i);
    }

    // Mostrar los productos ordenados
    for (int i = 0; i < numProductos; ++i) {
        productos[i]->mostrarDetalles();
    }
}

    void agregarProducto(Producto* nuevoProducto) {
        if (numProductos < MAX_PRODUCTOS) {
            productos[numProductos++] = nuevoProducto;
        } else {
            cout << "Error: Inventario lleno, no se puede agregar más productos." << endl;
        }
    }

    void eliminarProducto(const string& codigoBarras) {
        for (int i = 0; i < numProductos; ++i) {
            if (productos[i]->getCodigoBarras() == codigoBarras) {
                delete productos[i];
                productos[i] = productos[--numProductos];
                cout << "Producto eliminado correctamente." << endl;
                return;
            }
        }
        cout << "Error: Producto no encontrado en el inventario." << endl;
    }

    Producto* buscarProductoPorCodigo(const string& codigoBarras) const {
        for (int i = 0; i < numProductos; ++i) {
            if (productos[i]->getCodigoBarras() == codigoBarras) {
                return productos[i];
            }
        }
        return nullptr;
    }

    Producto* buscarProductoPorNombre(const string& nombre) const {
        for (int i = 0; i < numProductos; ++i) {
            if (productos[i]->getNombre() == nombre) {
                return productos[i];
            }
        }
        return nullptr;
    }

    void buscarProductosPorCategoria(const string& categoria) const {
        for (int i = 0; i < numProductos; ++i) {
            if (productos[i]->getCategoria() == categoria) {
                productos[i]->mostrarDetalles();
            }
        }
    }

    int getNumProductos() const {
        return numProductos;
    }

    Producto* getProducto(int posicion) const {
        return productos[posicion];
    }
};

// Función genérica para comparar productos por cantidad
template <typename Producto>
bool compararPorCantidadDesc(Producto* a, Producto* b) {
    return a->getCantidad() > b->getCantidad();
}

// Función genérica para ordenar productos utilizando un comparador
template <typename Producto>
void ordenarProductos(const Inventario<Producto>& inventario, bool (comparador)(Producto, Producto*)) {
    // Crear un arreglo de productos temporal para el ordenamiento
    int numProductos = inventario.getNumProductos();
    Producto* productos[MAX_PRODUCTOS];

    for (int i = 0; i < numProductos; ++i) {
        productos[i] = inventario.getProducto(i);
    }

    // Algoritmo de ordenamiento por selección adaptado dentro de la función genérica
    for (int i = 0; i < numProductos - 1; ++i) {
        int min = i;
        for (int j = i + 1; j < numProductos; ++j) {
            if (comparador(productos[j], productos[min])) {
                min = j;
            }
        }
        // Intercambiar elementos solo si el mínimo no está en su posición actual
        if (min != i) {
            Producto* temp = productos[i];
            productos[i] = productos[min];
            productos[min] = temp;
        }
    }

    // Mostrar los productos ordenados
    for (int i = 0; i < numProductos; ++i) {
        productos[i]->mostrarDetalles();
    }
}

// Función para generar un reporte de productos más vendidos
template <typename Producto>
void generarReporteMasVendidos(const Inventario<Producto>& inventario) {
    cout << "Reporte de productos más vendidos:" << endl;
    
    // Llamamos a ordenarProductos con el comparador de cantidad
    ordenarProductos(inventario, compararPorCantidadDesc<Producto>);
}

// Función para generar un reporte de productos por categoría
template <typename Producto>
void generarReportePorCategoria(const Inventario<Producto>& inventario, const string& categoria) {
    cout << "Reporte de productos en la categoría '" << categoria << "':" << endl;
    inventario.buscarProductosPorCategoria(categoria);
}

// Declaración de funciones
void agregarProducto(Inventario<Producto<ProductoBase>>& inventario);
void actualizarProducto(Inventario<Producto<ProductoBase>>& inventario);
void eliminarProducto(Inventario<Producto<ProductoBase>>& inventario);
void buscarProductoPorCodigo(Inventario<Producto<ProductoBase>>& inventario);
void buscarProductoPorNombre(Inventario<Producto<ProductoBase>>& inventario);
void generarReportePorCategoria(Inventario<Producto<ProductoBase>>& inventario);
void generarReporteMasVendidos(Inventario<Producto<ProductoBase>>& inventario);
void salir();

void mostrarMenu() {
    cout << "Menú de Opciones:" << endl;
    cout << "1. Agregar Producto" << endl;
    cout << "2. Actualizar Información de Producto" << endl;
    cout << "3. Eliminar Producto" << endl;
    cout << "4. Buscar Producto por Código de Barras" << endl;
    cout << "5. Buscar Producto por Nombre" << endl;
    cout << "6. Generar Reporte de Productos por Categoría" << endl;
    cout << "7. Generar Reporte de Productos Más Vendidos" << endl;
    cout << "8. Salir" << endl;
}

void agregarProducto(Inventario<Producto<ProductoBase>>& inventario) {
    string nombre, codigoBarras, categoria, fechaVencimiento;
    double precio;
    int cantidad;

    cout << "Ingrese nombre del producto: ";
    cin >> nombre;

    cout << "Ingrese código de barras: ";
    cin >> codigoBarras;

    cout << "Ingrese precio: ";
    cin >> precio;

    cout << "Ingrese cantidad: ";
    cin >> cantidad;

    cout << "Ingrese categoría: ";
    cin >> categoria;

    cout << "Ingrese fecha de vencimiento (opcional): ";
    cin >> fechaVencimiento;

    auto producto = new Producto<ProductoBase>(nombre, codigoBarras, precio, cantidad, categoria, fechaVencimiento);
    inventario.agregarProducto(producto);
    cout << "Producto agregado exitosamente." << endl;
}

void actualizarProducto(Inventario<Producto<ProductoBase>>& inventario) {
    string codigoBarras;
    cout << "Ingrese el código de barras del producto a actualizar: ";
    cin >> codigoBarras;

    Producto<ProductoBase>* producto = inventario.buscarProductoPorCodigo(codigoBarras);
    if (producto) {
        double nuevoPrecio;
        int nuevaCantidad;
        string nuevaFechaVencimiento;

        cout << "Ingrese nuevo precio: ";
        cin >> nuevoPrecio;

        cout << "Ingrese nueva cantidad: ";
        cin >> nuevaCantidad;

        cout << "Ingrese nueva fecha de vencimiento (opcional): ";
        cin >> nuevaFechaVencimiento;

        producto->actualizarPrecio(nuevoPrecio);
        producto->actualizarCantidad(nuevaCantidad);
        if (!nuevaFechaVencimiento.empty()) {
            producto->actualizarFechaVencimiento(nuevaFechaVencimiento);
        }
        cout << "Producto actualizado exitosamente." << endl;
    } else {
        cout << "Producto no encontrado." << endl;
    }
}

void eliminarProducto(Inventario<Producto<ProductoBase>>& inventario) {
    string codigoBarras;
    cout << "Ingrese el código de barras del producto a eliminar: ";
    cin >> codigoBarras;
    inventario.eliminarProducto(codigoBarras);
}

void buscarProductoPorCodigo(Inventario<Producto<ProductoBase>>& inventario) {
    string codigoBarras;
    cout << "Ingrese el código de barras del producto a buscar: ";
    cin >> codigoBarras;
    Producto<ProductoBase>* producto = inventario.buscarProductoPorCodigo(codigoBarras);
    if (producto) {
        producto->mostrarDetalles();
    } else {
        cout << "Producto no encontrado." << endl;
    }
}

void buscarProductoPorNombre(Inventario<Producto<ProductoBase>>& inventario) {
    string nombre;
    cout << "Ingrese el nombre del producto a buscar: ";
    cin >> nombre;
    Producto<ProductoBase>* producto = inventario.buscarProductoPorNombre(nombre);
    if (producto) {
        producto->mostrarDetalles();
    } else {
        cout << "Producto no encontrado." << endl;
    }
}

void generarReportePorCategoria(Inventario<Producto<ProductoBase>>& inventario) {
    string categoria;
    cout << "Ingrese la categoría para generar el reporte: ";
    cin >> categoria;
    cout << "Reporte de productos en la categoría '" << categoria << "':" << endl;
    inventario.buscarProductosPorCategoria(categoria);
}

void generarReporteMasVendidos(Inventario<Producto<ProductoBase>>& inventario) {
    cout << "Reporte de productos más vendidos:" << endl;
    
    // Llamamos a ordenarProductos con el comparador de cantidad
    ordenarProductos(inventario, compararPorCantidadDesc<Producto<ProductoBase>>);
}

void salir() {
    cout << "Saliendo del programa..." << endl;
}

int main() {
    Inventario<Producto<ProductoBase>> inventario;
    int opcion;

    // Arreglo de punteros a funciones
    void (*funciones[])(Inventario<Producto<ProductoBase>>& inventario) = {
        agregarProducto,
        actualizarProducto,
        eliminarProducto,
        buscarProductoPorCodigo,
        buscarProductoPorNombre,
        generarReportePorCategoria,
        generarReporteMasVendidos
    };

    do {
        mostrarMenu();
        cout << "Selecciona una opción: ";
        cin >> opcion;

        if (opcion >= 1 && opcion <= 7) {
            funciones[opcion - 1](inventario);
        } else if (opcion == 8) {
            salir();
        } else {
            cout << "Opción no válida, por favor intenta de nuevo." << endl;
        }

    } while (opcion != 8);

    return 0;
}

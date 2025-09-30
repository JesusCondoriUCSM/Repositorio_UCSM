import React, { Component } from "react";

class Menu extends Component {
  productos = [
    { 
      nombre: "Laptop Acer Nitro 16", 
      precio: 4400, 
      imagen: "https://www.pcfactory.com.pe/public/foto/3997/1_200.jpg?t=1758641420195" 
    },
    { 
      nombre: "Laptop Acer Nitro V 15.6", 
      precio: 4000, 
      imagen: "https://www.pcfactory.com.pe/public/foto/3489/1_200.jpg?t=1758641422779" 
    },
    { 
      nombre: "Laptop Acer Nitro V i9", 
      precio: 5700, 
      imagen: "https://www.pcfactory.com.pe/public/foto/3749/1_200.jpg?t=1758641425640" 
    },
    { 
      nombre: "Laptop Acer Nitro V i7", 
      precio: 4900, 
      imagen: "https://www.pcfactory.com.pe/public/foto/3490/1_200.jpg?t=1758641428276" 
    },
  ];

  render() {
    const { onComprar } = this.props;

    return (
      <div>
        <h1>Lista de Productos</h1>
        <div style={{ display: "flex", gap: "20px", flexWrap: "wrap" }}>
          {this.productos.map((p, index) => (
            <div 
              key={index} 
              style={{
                border: "1px solid #ccc",
                borderRadius: "10px",
                padding: "10px",
                width: "220px",
                textAlign: "center"
              }}
            >
              <img 
                src={p.imagen} 
                alt={p.nombre} 
                style={{ width: "200px", height: "150px", objectFit: "cover", borderRadius: "8px" }} 
              />
              <h3>{p.nombre}</h3>
              <p><strong>S/. {p.precio}</strong></p>
              <button onClick={() => onComprar(p)}>Comprar</button>
            </div>
          ))}
        </div>
      </div>
    );
  }
}

export default Menu;

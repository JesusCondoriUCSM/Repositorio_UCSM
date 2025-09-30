import React, { Component } from "react";

class Carrito extends Component {
  render() {
    const { carrito, onEliminar } = this.props; // recibe también la función de eliminar

    return (
      <div>
        <h1>Carrito de Compras</h1>

        {carrito.length === 0 ? (
          <p>El carrito está vacío</p>
        ) : (
          <ul style={{ listStyle: "none", padding: 0 }}>
            {carrito.map((item, index) => (
              <li
                key={index}
                style={{
                  display: "flex",
                  alignItems: "center",
                  marginBottom: "10px",
                  borderBottom: "1px solid #ccc",
                  paddingBottom: "10px",
                }}
              >
                <img
                  src={item.imagen}
                  alt={item.nombre}
                  style={{ width: "60px", height: "60px", marginRight: "10px", borderRadius: "5px" }}
                />
                <div style={{ flexGrow: 1 }}>
                  <strong>{item.nombre}</strong> <br />
                  <span>S/. {item.precio}</span>
                </div>
                <button
                  onClick={() => onEliminar(index)}
                  style={{
                    background: "red",
                    color: "white",
                    border: "none",
                    borderRadius: "5px",
                    padding: "5px 10px",
                    cursor: "pointer",
                  }}
                >
                  Eliminar
                </button>
              </li>
            ))}
          </ul>
        )}
      </div>
    );
  }
}

export default Carrito;

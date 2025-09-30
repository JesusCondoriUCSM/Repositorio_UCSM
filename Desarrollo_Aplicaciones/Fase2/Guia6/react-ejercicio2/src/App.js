import './App.css';
import React, {Component} from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Carrito from './Carrito';
import Menu from './Menu';

class App extends Component {
  state = {
    carrito: []
  }

  handleAgregar = (producto) => {
    this.setState({ carrito: [...this.state.carrito, producto] });
  }

  handleEliminar = (index) => {
    const nuevoCarrito = this.state.carrito.filter((_, i) => i !== index);
    this.setState({ carrito: nuevoCarrito });
  }

  render() {
    return (
      <Router>
        <div>
          <nav>
            <ul>
              <li>
                <Link to="/listproductos">Lista de Productos</Link>
              </li>
              <li>
                <Link to="/carrito">Carrito de Compras</Link>
              </li>
            </ul>
          </nav>

          <Routes>
            <Route path="/listproductos" element={<Menu onComprar={this.handleAgregar} />} />
            <Route path="/carrito" element={<Carrito carrito={this.state.carrito} onEliminar={this.handleEliminar} />} />
          </Routes>
        </div>
      </Router>
    )
  }
}

export default App


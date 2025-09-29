import React,{Component} from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import About from "./About";

class App extends Component {
    render(){
        return (
    
    <Router>
      <div>
        <h1>Navegación</h1>
        <nav>
          <ul>
            <li>
              <Link to="/home">Menú Principal</Link>
            </li>
            <li>
              <Link to="/about">Productos</Link>
            </li>
          </ul>
        </nav>

        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </div>
    </Router>
  );
    }
  
}

export default App;

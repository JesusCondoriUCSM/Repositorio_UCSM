import React,{Component} from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import About from "./About";

class App extends Component {
    render(){
        return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/home">Ir a Home</Link>
            </li>
            <li>
              <Link to="/about">Ir a About</Link>
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

import React from 'react';
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from './pages/Layout';
import NoPage from './pages/NoPage';
import Articulos from './pages/Articulos';
import ArticuloDetalle from './pages/ArticuloDetalle';
import Autor from './pages/Autor';
import Home from './pages/Home';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="articulos" element={<Articulos />} />
          <Route path="articulos/:id" element={<ArticuloDetalle />} >
            <Route path="autor" element={<Autor />}/>
          </Route>
          <Route path="*" element={<NoPage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);



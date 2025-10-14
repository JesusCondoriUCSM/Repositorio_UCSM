import {Link} from "react-router-dom";

export const Articulos = () =>{
    const articulos = [
        {id:1, titulo: "Como mejorar tu productividad"},
        {id:2, titulo: "Introducción a React"},
        {id:3, titulo: "Consejos para escribir código limpio"},
        {id:4, titulo: "Qué es la inteligencia artificial"},
    ];
    
    return (
        <div>
            <h2>Lista de Articulos</h2>
            <ul>
                {articulos.map((articulo) =>(
                    <li key={articulo.id}>
                        <Link to={`/articulos/${articulo.id}`}>{articulo.titulo}</Link>
                    </li>
                ))}
            </ul>
        </div>

    );
}

export default Articulos;
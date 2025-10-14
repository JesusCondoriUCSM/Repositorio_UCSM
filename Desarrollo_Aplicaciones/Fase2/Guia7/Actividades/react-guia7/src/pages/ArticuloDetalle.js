import { useParams,Link,Outlet } from "react-router-dom";

const ArticuloDetalle = () =>{
    const {id} = useParams();

    const articulos = {
    1: {
      titulo: "Cómo mejorar tu productividad",
      contenido: "Este artículo trata sobre cómo mejorar tus hábitos diarios...",
    },
    2: {
      titulo: "Introducción a React",
      contenido: "React es una biblioteca de JavaScript para construir interfaces...",
    },
    3: {
      titulo: "Consejos para escribir código limpio",
      contenido: "El código limpio es fácil de leer, mantener y extender...",
    },
    4: {
      titulo: "Qué es la inteligencia artificial",
      contenido: "La inteligencia artificial es un campo de la informática que...",
    },
  };

  const articulo = articulos[id];

  if(!articulo) return <p>Artículo no encontrado</p>;

  return (
    <div>
        <h2>{articulo.titulo}</h2>
        <p>{articulo.contenido}</p>
        <Link to="autor">Sobre el Autor</Link>

        <Outlet />
    </div>
  );
};

export default ArticuloDetalle;
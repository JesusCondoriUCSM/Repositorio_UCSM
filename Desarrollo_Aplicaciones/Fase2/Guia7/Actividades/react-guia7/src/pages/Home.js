import { useNavigate } from "react-router-dom";

const Home = () =>{
    const navigate = useNavigate();
 
    const handleRandomArticle = () =>{
        const randomId = Math.floor(Math.random() * 4)+1;
        navigate(`/articulos/${randomId}`)
    }

    return(
    <div>
        <h1>Bienvenido!!</h1>
        <button onClick={handleRandomArticle}>
            Leer un Artículo Aleatorio
        </button>

    </div>

 )

};

export default Home;

import { Outlet, Link } from "react-router-dom";
const Layout = () => {
    return (
    <>
    <nav>
    <ul>
        <li>
            <Link to="/">Inicio</Link>
        </li>
        <li>
            <Link to="/articulos">Artículos</Link>
        </li>
    </ul>
    </nav>
    <Outlet />
    
    <footer>
        <p>@ 2025 Mi Blog</p>
    </footer>
    </>
    );
};
export default Layout;

package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection cx = null;

    public Connection conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            cx = DriverManager.getConnection("jdbc:sqlite:Usuario.db");
            System.out.println("Conexión establecida");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cx;
    }

    public void desconectar() {
        if (cx != null) {
            try {
                cx.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return cx;
    }
}

package conexion;

import java.sql.*;

/**
 *
 * @author ortiz
 */
public class Conexion {
    //Conexión local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_vehiculos", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en la conexión local " + e);
        }
        return null;
    }
}

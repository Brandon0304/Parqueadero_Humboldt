package controlador;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ortiz
 */
public class UsuarioController {

    //Método para iniciar sesion
    public boolean login(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "select usuario, contraseña from tb_usuario where usuario = '" + objeto.getUsuario()
                + "' and contraseña = '" + objeto.getContraseña() + "'";

        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }
        return respuesta;
    }

}

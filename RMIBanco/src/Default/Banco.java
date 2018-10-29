/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import Default.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author patri
 */
public class Banco {

    public void crearSucursal(String sucursal, String ciudades) {

        String[] parts = ciudades.split("-");
        String part1 = parts[0];
        int ciudad = Integer.parseInt(part1);
        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conectarMySQL();
            PreparedStatement pst = cn.prepareStatement("INSERT INTO sucursal (nombre, idcuidad) VALUES(?,?)");
            pst.setString(1, sucursal);
            pst.setInt(2, ciudad);
            int a = pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar");
            }
        } catch (Exception e) {
        }
    }

    public void buscarCiudad(JComboBox BoxCiudad) {
        try {
            String sql = "";
            Conexion cc = new Conexion();
            Connection cn = cc.conectarMySQL();
            BoxCiudad.addItem("Seleccione una opción");
            sql = "SELECT id, nombre FROM cuidad";
            String[] datos = new String[10];
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                BoxCiudad.addItem(rs.getString("id") + "-" + rs.getString("nombre"));
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CrearSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import Default.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author patri
 */
public class Banco {

    public void crearSucursal(String sucursal, int ciudad) {
        Conexion cc = new Conexion();
        Connection cn = cc.conectarMySQL();
        try {
            PreparedStatement pst = cn.prepareStatement("INSERT INTO sucursal(nombre,idciudad) VALUES(?,?)");
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

}

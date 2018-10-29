/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author patri
 */
public class Conexion {

    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    public String username = "root";
    public String password = "Happy123$";
    public String url = "jdbc:mysql://localhost:3306/bdrmi?autoReconnect=true&useSSL=false";

    public Connection conectarMySQL() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar" + e);
        }

        return conn;
    }

    public int ingresoSesion(String num, String clave) throws SQLException {
        String sql = "";
        int rol = 0;
        if (num.equals("") && clave.equals("")) {
            return 0;
        } else {
            sql = "SELECT * FROM usuario WHERE (numeroidentificacion ='" + num + "'  AND clave='" + clave + "')";
            String[] datos = new String[10];
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                rol = Integer.parseInt(rs.getString(5));
                datos[5] = rs.getString(6);
            }
        }
        return rol;
    }
}

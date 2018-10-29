package Cliente;

import Default.Conexion;
import Default.LoginAdmin;
import java.sql.Connection;

public class cliente {

    public static void main(String args[]) {
        Conexion conn = new Conexion();
        Connection reg= conn.conectarMySQL();
        
        LoginAdmin obj = new LoginAdmin();
        obj.setVisible(true);
    }
}

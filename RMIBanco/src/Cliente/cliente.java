package Cliente;

import Default.Conexion;
import Default.CrearSucursal;
import java.sql.Connection;

public class cliente {

    public static void main(String args[]) {
        Conexion conn = new Conexion();
        Connection reg= conn.conectarMySQL();
        
        CrearSucursal obj = new CrearSucursal();
        obj.setVisible(true);
    }
}

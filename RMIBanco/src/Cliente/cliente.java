package Cliente;

import Servidor.Conexion;
import Vistas.CrearSucursal;
import java.sql.Connection;

public class cliente {

    public static void main(String args[]) {
        Conexion conn = new Conexion();
        Connection reg = conn.conectarMySQL();
        
        CrearSucursal ob = new CrearSucursal();
        ob.setVisible(true);
    }
}

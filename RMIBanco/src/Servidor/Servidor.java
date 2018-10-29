package Servidor;

import Cliente.LoginAdmin;
import Vistas.AdminInicio;
import Vistas.UsuarioInicio;
import Interface.Interface;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class Servidor extends UnicastRemoteObject implements Interface {

    private static final long serialVersionUID = 1L;

    public Servidor() throws RemoteException {
        super();
    }

    public static void main(String args[]) {
        try {
            Registry registro = LocateRegistry.createRegistry(3306);
            registro.rebind("jdbc:mysql://localhost:3306/bdrmi", new Servidor()); //mantiene al servidor en constante escucha
            System.out.println("El servidor esta activo");
        } catch (Exception e) {
            System.err.println("Excepcion del Servidor: " + e.getMessage());
        }
    }

    @Override
    public int ingresoSesion(String num, String clave) throws RemoteException {
        int ini = 0;
        try {
            Conexion c = new Conexion();
            ini = c.ingresoSesion(num, clave);
            switch (ini) {
                case 1:
                    AdminInicio admin = new AdminInicio();
                    admin.setVisible(true);
                    break;
                case 2:
                    UsuarioInicio usu = new UsuarioInicio();
                    usu.setVisible(true);
                    break;
                default:
                    System.out.println("Este Usuario no exixte en nuestra base de datos por favor acercarse a una de nuestras oficinas");
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ini;
    }
}

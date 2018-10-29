
package Interface;

//Clase para "marcar" un objeto remotamente accesible

import java.rmi.RemoteException;

public interface Interface extends java.rmi.Remote {
    public int ingresoSesion(String num, String clave) throws RemoteException;
}

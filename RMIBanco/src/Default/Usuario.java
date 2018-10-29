
package Default;

/**
 *
 * @author ACER
 */
public class Usuario {
    private String nombrecompleto;
    private int idTipoIdentificacion;
    private int numeroIdentificacion;
    private int IdRol;
    private String contraseña;

    public Usuario(String nombrecompleto, int idTipoIdentificacion, int numeroIdentificacion, int IdRol, String contraseña) {
        this.nombrecompleto = nombrecompleto;
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.IdRol = IdRol;
        this.contraseña = contraseña;
    }
    
    public String crearUsuario(){
        
        return null;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public int getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(int idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}

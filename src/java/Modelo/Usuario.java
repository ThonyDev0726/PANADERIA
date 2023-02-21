package Modelo;

public class Usuario {

    public Integer idUsuario;
    public String usuUsuario;
    public String usuClave;

    public Usuario(String usuUsuario, String usuClave) {
        this.usuUsuario = usuUsuario;
        this.usuClave = usuClave;
    }

    public Usuario(Integer idUsuario, String usuUsuario, String usuClave) {
        this.idUsuario = idUsuario;
        this.usuUsuario = usuUsuario;
        this.usuClave = usuClave;
    }
    
    
    public Usuario() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuUsuario() {
        return usuUsuario;
    }

    public void setUsuUsuario(String usuUsuario) {
        this.usuUsuario = usuUsuario;
    }

    public String getUsuClave() {
        return usuClave;
    }

    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }


}

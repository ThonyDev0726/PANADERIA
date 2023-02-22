package Modelo;

public class CLIENTES{

    public Integer idCliente;
    public String cliNombres;
    public String cliCedula;
    public String cliApellidos;
    public String cliFecha;
    public String cliDireccion;
    public String cliTelefono;

    public CLIENTES() {
    }

    public CLIENTES(String cliNombres, String cliCedula, String cliApellidos, String cliFecha, String cliDireccion, String cliTelefono) {
        this.cliNombres = cliNombres;
        this.cliCedula = cliCedula;
        this.cliApellidos = cliApellidos;
        this.cliFecha = cliFecha;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
    }

    public CLIENTES(Integer idCliente, String cliNombres, String cliCedula, String cliApellidos, String cliFecha, String cliDireccion, String cliTelefono) {
        this.idCliente = idCliente;
        this.cliNombres = cliNombres;
        this.cliCedula = cliCedula;
        this.cliApellidos = cliApellidos;
        this.cliFecha = cliFecha;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
    }

    public CLIENTES(Integer idCliente, String cliNombres, String cliCedula, String cliApellidos, String cliDireccion, String cliTelefono) {
        this.idCliente = idCliente;
        this.cliNombres = cliNombres;
        this.cliCedula = cliCedula;
        this.cliApellidos = cliApellidos;
        this.cliDireccion = cliDireccion;
        this.cliTelefono = cliTelefono;
    }
    

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }


    public String getCliNombres() {
        return cliNombres;
    }

    public void setCliNombres(String cliNombre) {
        this.cliNombres = cliNombre;
    }

    public String getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public String getCliFecha() {
        return cliFecha;
    }

    public void setCliFecha(String cliFecha) {
        this.cliFecha = cliFecha;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }

    public String getCliTelefono() {
        return cliTelefono;
    }

    public void setCliTelefono(String cliTelefono) {
        this.cliTelefono = cliTelefono;
    }

}

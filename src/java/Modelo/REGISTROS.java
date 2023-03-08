package Modelo;

public class REGISTROS {

    public Integer idRegistro;
    public Integer fkCliente;
    public String regCliente;
    public String regProducto;
    public Integer fkProducto;
    public String regFecha;
    public Integer regCantidad;
    public String regTipo;

    public REGISTROS(String regFecha, Integer regNumero, String regTipo) {
        this.regFecha = regFecha;
        this.regCantidad = regNumero;
        this.regTipo = regTipo;
    }

    public REGISTROS(Integer idRegistro, String regFecha, Integer regNumero, String regTipo) {
        this.idRegistro = idRegistro;
        this.regFecha = regFecha;
        this.regCantidad = regNumero;
        this.regTipo = regTipo;
    }

    public REGISTROS(String regFecha, Integer regCantidad, String regTipo, Integer fkCliente, Integer fkProducto) {
        this.fkCliente = fkCliente;
        this.fkProducto = fkProducto;
        this.regFecha = regFecha;
        this.regCantidad = regCantidad;
        this.regTipo = regTipo;
    }

    public Integer getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Integer fkCliente) {
        this.fkCliente = fkCliente;
    }

    public String getRegCliente() {
        return regCliente;
    }

    public void setRegCliente(String regCliente) {
        this.regCliente = regCliente;
    }

    public String getRegProducto() {
        return regProducto;
    }

    public void setRegProducto(String regProducto) {
        this.regProducto = regProducto;
    }

    public Integer getFkProducto() {
        return fkProducto;
    }

    public void setFkProducto(Integer fkProducto) {
        this.fkProducto = fkProducto;
    }

    public Integer getRegCantidad() {
        return regCantidad;
    }

    public void setRegCantidad(Integer regCantidad) {
        this.regCantidad = regCantidad;
    }

    public REGISTROS() {
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getRegFecha() {
        return regFecha;
    }

    public void setRegFecha(String regFecha) {
        this.regFecha = regFecha;
    }

    public String getRegTipo() {
        return regTipo;
    }

    public void setRegTipo(String regTipo) {
        this.regTipo = regTipo;
    }

}

package Modelo;

public class Registro {

    public Integer idRegistro;
    public String regFecha;
    public Integer regNumero;
    public String regTipo;

    public Registro() {
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

    public Integer getRegNumero() {
        return regNumero;
    }

    public void setRegNumero(Integer regNumero) {
        this.regNumero = regNumero;
    }

    public String getRegTipo() {
        return regTipo;
    }

    public void setRegTipo(String regTipo) {
        this.regTipo = regTipo;
    }

}

package Modelo;

public class Insumo {

    public Integer idInsumo;
    public String incNombre;
    public Float incPrecio;
    public String incCompra;
    public Integer incCantidad;
    public String incTipo;

    public Insumo() {
    }

    public Insumo(String incNombre, Float incPrecio, String incCompra, Integer incCantidad, String incTipo) {
        this.incNombre = incNombre;
        this.incPrecio = incPrecio;
        this.incCompra = incCompra;
        this.incCantidad = incCantidad;
        this.incTipo = incTipo;
    }
    

    public Integer getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getIncNombre() {
        return incNombre;
    }

    public void setIncNombre(String incNombre) {
        this.incNombre = incNombre;
    }

    public String getIncCompra() {
        return incCompra;
    }

    public void setIncCompra(String incCompra) {
        this.incCompra = incCompra;
    }

    public Float getIncPrecio() {
        return incPrecio;
    }

    public void setIncPrecio(Float incPrecio) {
        this.incPrecio = incPrecio;
    }

    public Integer getIncCantidad() {
        return incCantidad;
    }

    public void setIncCantidad(Integer incCantidad) {
        this.incCantidad = incCantidad;
    }

    public String getIncTipo() {
        return incTipo;
    }

    public void setIncTipo(String incTipo) {
        this.incTipo = incTipo;
    }

}

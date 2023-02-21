package Modelo;

public class Producto {

    public Integer idProducto;
    public String proNombre;
    public Integer proCantidad;
    public Float proPrecio;
    public String proElaboracion;

    public Producto() {
    }

    public Producto(String proNombre, Integer proCantidad, Float proPrecio, String proElaboracion) {
        this.proNombre = proNombre;
        this.proCantidad = proCantidad;
        this.proPrecio = proPrecio;
        this.proElaboracion = proElaboracion;
    }

    public Producto(Integer idProducto, String proNombre, Integer proCantidad, Float proPrecio, String proElaboracion) {
        this.idProducto = idProducto;
        this.proNombre = proNombre;
        this.proCantidad = proCantidad;
        this.proPrecio = proPrecio;
        this.proElaboracion = proElaboracion;
    }
    

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public Integer getProCantidad() {
        return proCantidad;
    }

    public void setProCantidad(Integer proCantidad) {
        this.proCantidad = proCantidad;
    }

    public Float getProPrecio() {
        return proPrecio;
    }

    public void setProPrecio(Float proPrecio) {
        this.proPrecio = proPrecio;
    }

    public String getProElaboracion() {
        return proElaboracion;
    }

    public void setProElaboracion(String proElaboracion) {
        this.proElaboracion = proElaboracion;
    }

}

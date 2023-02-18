package Interfaces;

import Modelo.Producto;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_producto {

    public List listar();

    public Producto list(int idProducto);

    public String add(Producto cli);

    public String update(Producto cli);

    public String delete(int id);

}

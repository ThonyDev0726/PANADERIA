package Interfaces;

import Modelo.PRODUCTOS;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_producto {

    public List listar();

    public PRODUCTOS list(int idProducto);

    public String add(PRODUCTOS cli);

    public String update(PRODUCTOS cli);

    public String delete(int id);

}

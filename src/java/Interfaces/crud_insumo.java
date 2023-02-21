package Interfaces;

import Modelo.INSUMOS;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_insumo {

    public List listar();

    public INSUMOS list(int idInsumo);

    public String add(INSUMOS cli);

    public String update(INSUMOS cli);

    public String delete(int id);

}

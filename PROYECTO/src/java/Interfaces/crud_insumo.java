package Interfaces;

import Modelo.Insumo;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_insumo {

    public List listar();

    public Insumo list(int idInsumo);

    public String add(Insumo cli);

    public String update(Insumo cli);

    public String delete(int id);

}

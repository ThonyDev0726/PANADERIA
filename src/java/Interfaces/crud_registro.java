package Interfaces;

import Modelo.Registro;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_registro {

    public List listar();

    public Registro list(int idRegistro);

    public String add(Registro cli);

    public String update(Registro cli);

    public String delete(int id);

}

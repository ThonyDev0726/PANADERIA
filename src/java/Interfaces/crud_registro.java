package Interfaces;

import Modelo.REGISTROS;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_registro {

    public List listar();

    public REGISTROS list(int idRegistro);

    public String add(REGISTROS cli);

    public String update(REGISTROS cli);

    public String delete(int id);

}

package Interfaces;

import Modelo.CLIENTES;
import Modelo.REGISTROS;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_cliente {

    public List listar();

    public CLIENTES list(int idCliente);

    public String add(CLIENTES cli);

    public String update(CLIENTES cli);

    public String delete(int id);

}

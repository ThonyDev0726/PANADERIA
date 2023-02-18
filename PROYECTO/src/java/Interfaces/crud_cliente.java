package Interfaces;

import Modelo.Cliente;
import Modelo.Registro;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_cliente {

    public List listar();

    public Cliente list(int idCliente);

    public String add(Cliente cli);

    public String update(Cliente cli);

    public String delete(int id);

}

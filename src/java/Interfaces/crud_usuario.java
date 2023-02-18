package Interfaces;

import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author perez
 */
public interface crud_usuario {

    public List listar();

    public Usuario list(int idUsuario);

    public String add(Usuario cli);

    public String update(Usuario cli);

    public String delete(int id);

}

package ModeloDao;

import Conexion.Conexion;
import Interfaces.crud_usuario;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements crud_usuario {

    Usuario c = new Usuario();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR = "CALL SELECT_Usuario_ALL()";
    String LISTAR_ID = "CALL A_S_ID_Usuario(?)";
    String CREAR = "CALL INSERT_UsuarioS(?,?,?,?,?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_Usuario(?,?,?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_Usuario(?)";

    @Override
    public List listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                Usuario cli = new Usuario();
                cli.setIdUsuario(rs.getInt(1));
                cli.setUsuUsuario(rs.getString(2));
                cli.setUsuClave(rs.getString(3));
                lista.add(cli);
            }
            System.out.println("SE ESTA LISTANDO LOS UsuarioS");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS UsuarioS" + ex);
        }
        return lista;
    }

    @Override
    public Usuario list(int id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setIdUsuario(rs.getInt(1));
                c.setUsuUsuario(rs.getString(2));
                c.setUsuClave(rs.getString(3));;
            }
            System.out.println("SE ESTA LISTANDO EL Usuario");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS UsuarioS" + ex);
        }
        return c;
    }

    @Override
    public String add(Usuario cli) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setString(1, cli.getUsuUsuario());
            cs.setString(2, cli.getUsuClave());
            cs.execute();
            System.out.println("SE CREO EL Usuario CON EXITO");
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL Usuario");
            System.out.println(ex);
            return "El Usuario no fue creado!";
        }
        return "El Usuario fue creado con exito!";
    }

    @Override
    public String update(Usuario cli) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, cli.getIdUsuario());
             cs.setString(2, cli.getUsuUsuario());
            cs.setString(3, cli.getUsuClave());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL Usuario");
            System.out.println(ex);
            return "El Usuario no fue actualizado!";
        }
        return "El Usuario fue actualizado con exito!";
    }

    @Override
    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println("SE ELIMINO EL Usuario: " + id);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Usuario!");
            System.out.println(ex);
            return "Error al eliminar el Usuario!";
        }
        return "El Usuario fue eliminado con exito!";
    }

}

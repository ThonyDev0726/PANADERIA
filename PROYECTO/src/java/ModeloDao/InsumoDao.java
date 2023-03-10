package ModeloDao;

import Conexion.Conexion;
import Interfaces.crud_insumo;
import Modelo.Cliente;
import Modelo.Insumo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsumoDao implements crud_insumo {

    Insumo c = new Insumo();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR = "CALL SELECT_INSUMO()";
    String LISTAR_ID = "CALL A_S_ID_Cliente(?)";
    String CREAR = "CALL INSERT_INSUMOS(?,?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_Cliente(?,?,?,?,?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_Cliente(?)";

    @Override
    public List listar() {
        ArrayList<Insumo> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                Insumo cli = new Insumo();
                cli.setIdInsumo(rs.getInt(1));
                cli.setIncNombre(rs.getString(2));
                cli.setIncPrecio(rs.getFloat(3));
                cli.setIncCompra(rs.getString(4));
                cli.setIncCantidad(rs.getInt(5));
                cli.setIncTipo(rs.getString(6));
                lista.add(cli);
            }
            System.out.println("SE ESTA LISTANDO LOS ClienteS");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS ClienteS" + ex);
        }
        return lista;
    }

    @Override
    public Insumo list(int id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setIdInsumo(rs.getInt(1));
                c.setIncNombre(rs.getString(2));
                c.setIncPrecio(rs.getFloat(3));
                c.setIncCantidad(rs.getInt(4));
                c.setIncTipo(rs.getString(5));
            }
            System.out.println("SE ESTA LISTANDO EL Cliente");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS ClienteS" + ex);
        }
        return c;
    }

    @Override
    public String add(Insumo cli) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setString(1, cli.getIncNombre());
            cs.setFloat(2, cli.getIncPrecio());
            cs.setString(3, cli.getIncCompra());
            cs.setInt(4, cli.getIncCantidad());
            cs.setString(5, cli.getIncTipo());
            cs.execute();
            System.out.println("SE CREO EL Cliente CON EXITO");
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL INSUMO");
            System.out.println(ex);
            return "El INSUMO no fue creado!";
        }
        return "El Cliente fue creado con exito!";
    }

    @Override
    public String update(Insumo cli) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, cli.getIdInsumo());
            cs.setString(2, cli.getIncNombre());
            cs.setFloat(3, cli.getIncPrecio());
            cs.setInt(4, cli.getIncCantidad());
            cs.setString(5, cli.getIncTipo());
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL Cliente");
            System.out.println(ex);
            return "El Cliente no fue actualizado!";
        }
        return "El Cliente fue actualizado con exito!";
    }

    @Override
    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println("SE ELIMINO EL Cliente: " + id);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Cliente!");
            System.out.println(ex);
            return "Error al eliminar el Cliente!";
        }
        return "El Cliente fue eliminado con exito!";
    }

}

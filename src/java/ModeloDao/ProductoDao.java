package ModeloDao;

import Conexion.Conexion;
import Interfaces.crud_producto;
import Modelo.PRODUCTOS;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao implements crud_producto {

    PRODUCTOS c = new PRODUCTOS();
    Conexion cn = new Conexion();
    CallableStatement cs;
    Connection con;
    ResultSet rs;

    /* ============== VARIABLES PARA PROCEDIMIENTOS ALMACENADOS ==============*/
    String LISTAR = "CALL SELECT_PRODUCTOS()";
    String LISTAR_ID = "CALL A_S_ID_Producto(?)";
    String CREAR = "CALL INSERT_PRODUCTO(?,?,?,?)";
    String ACTUALIZAR = "CALL UPDATE_Producto(?,?,?,?,?)";
    String ELIMINAR = "CALL DELETE_PRODUCTO(?)";

    @Override
    public List listar() {
        ArrayList<PRODUCTOS> lista = new ArrayList<>();
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR);
            rs = cs.executeQuery();
            while (rs.next()) {
                PRODUCTOS cli = new PRODUCTOS();
                cli.setIdProducto(rs.getInt(1));
                cli.setProNombre(rs.getString(2));
                cli.setProCantidad(rs.getInt(3));
                cli.setProPrecio(rs.getFloat(4));
                cli.setProElaboracion(rs.getString(5));
                lista.add(cli);
            }
            System.out.println("SE ESTA LISTANDO LOS ProductoS");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS ProductoS" + ex);
        }
        return lista;
    }

    @Override
    public PRODUCTOS list(int id) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(LISTAR_ID);
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                c.setIdProducto(rs.getInt(1));
                c.setProNombre(rs.getString(2));
                c.setProCantidad(rs.getInt(3));
                c.setProPrecio(rs.getFloat(4));
                c.setProElaboracion(rs.getString(5));
            }
            System.out.println("SE ESTA LISTANDO EL Producto");
        } catch (SQLException ex) {
            System.out.println("ERROR AL LISTAR LOS ProductoS" + ex);
        }
        return c;
    }

    @Override
    public String add(PRODUCTOS cli) {
        try {
            con = (Connection) cn.getConexion();
            cs = con.prepareCall(CREAR);
            cs.setString(1, cli.getProNombre());
            cs.setInt(2, cli.getProCantidad());
            cs.setFloat(3, cli.getProPrecio());
            cs.setString(4, cli.getProElaboracion());
            cs.execute();
            System.out.println("SE CREO EL Producto CON EXITO");
        } catch (SQLException ex) {
            System.out.println("ERROR AL CREAR EL Producto");
            System.out.println(ex);
            return "El Producto no fue creado!";
        }
        return "El Producto fue creado con exito!";
    }

    @Override
    public String update(PRODUCTOS cli) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ACTUALIZAR);
            cs.setInt(1, cli.getIdProducto());
            cs.setString(2, cli.getProNombre());
            cs.setInt(3, cli.getProCantidad());
            cs.setFloat(4, cli.getProPrecio());
            cs.setString(5, cli.getProElaboracion());
            System.out.println("SE ACTUALIZO EL Producto CON EXITO");
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("ERROR AL ACTUALIZAR EL Producto");
            System.out.println(ex);
            return "El Producto no fue actualizado!";
        }
        return "El Producto fue actualizado con exito!";
    }

    @Override
    public String delete(int id) {
        try {
            con = (Connection) cn.getConexion();
            CallableStatement cs = con.prepareCall(ELIMINAR);
            cs.setInt(1, id);
            System.out.println("SE ELIMINO EL Producto: " + id);
            cs.execute();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Producto!");
            System.out.println(ex);
            return "Error al eliminar el Producto!";
        }
        return "El Producto fue eliminado con exito!";
    }

}
